package com.crud.card.repositorio;

import com.crud.card.modelo.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository//con esto consultamos la base de datos
public class CardRepository implements RepoCard {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Card> fiendAll() {

        String SQL = "SELECT * FROM cards WHERE status =1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Card.class));
    }

    @Override
    public int save(Card card) {
        String SQL = "INSERT INTO cards (name, number, type, cvv, status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(SQL, new Object[]{card.getName(), card.getNumber(), card.getType(), card.getCvv(), card.getStatus()});
    }

    @Override
    public int update(Card card) {
        String SQL = "UPDATE cards SET name=? , number=? , type=? , cvv=? WHERE id_card = ?";
        return jdbcTemplate.update(SQL,new Object[]{card.getName() , card.getNumber() , card.getType(),
                card.getCvv() , card.getId_card()});
    }

    @Override
    public int deleteById(int id) {
        String SQL = "UPDATE cards SET status=0 WHERE id_card = ?";
        return jdbcTemplate.update(SQL,new Object[]{id});
    }
}
