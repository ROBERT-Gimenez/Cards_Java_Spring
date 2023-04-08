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
    public List<Pendientes> allApproved(){
        String sql = "SELECT * FROM pendientes WHERE status = 'Aceptado'";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pendientes.class));
    }

    @Override
    public int save(Pendientes file) {
        String sql = "INSERT INTO pendientes (file_id, user_name, type_request, date_created, status) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{file.getFile_id(), file.getUser_name(), file.getType_request(),file.getDate_created() ,file.getStatus()});
    }

    @Override
    public int update(Pendientes file) {
        String sql = "UPDATE pendientes SET user_name=COALESCE(?, user_name), type_request=COALESCE(?, type_request), date_created=COALESCE(?, date_created), status=COALESCE(?, status) WHERE file_id=?";
        return jdbcTemplate.update(sql, new Object[]{file.getUser_name(), file.getType_request(), file.getDate_created(), file.getStatus(), file.getFile_id()});
    }

    @Override
    public int approveFile(int id) {
        String sql = "UPDATE pendientes SET status='Aceptado' WHERE file_id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
