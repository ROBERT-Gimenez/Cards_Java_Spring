package com.crud.card.repositorio;

import com.crud.card.modelo.Card;
import com.crud.card.modelo.Pendientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PendingRepo implements PendingInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Pendientes> allPending(){
        String sql = "SELECT * FROM pendientes WHERE status  != 'Aceptado'";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pendientes.class));
    }

    @Override
    public int save(Pendientes file) {
        String sql = "INSERT INTO cards (file_id, userName, typeRequest, dateCreated, status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, file.getFile_id(), file.getUserName(), file.getTypeRequest(),file.getDateCreated(),file.getStatus());
    }

    @Override
    public int update(Pendientes file) {
        String sql = "UPDATE pendientes SET userName=? , typeRequest=? , status=?  WHERE file_id = ?";
        return jdbcTemplate.update(sql, file.getFile_id(), file.getUserName(), file.getTypeRequest(),file.getDateCreated(),file.getStatus());
    }

    @Override
    public int approveFile(int id) {
        String sql = "UPDATE pendientes SET status='Aceptado' WHERE file_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
