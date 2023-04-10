package com.crud.card.repositorio;

import com.crud.card.modelo.Pendientes;
import com.crud.card.modelo.UserAndPending;
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
 /*   @Override
    public List<Pendientes> prueba() {
        String sql = "SELECT p.*, u.user_name, u.email FROM pendientes p JOIN users u ON p.file_id = u.id_request WHERE p.status != 'Aceptado'";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pendientes.class));
    }*/
    public List<UserAndPending> prueba() {
        String sql = " SELECT p.file_id, p.user_name, p.type_request, p.date_created, p.status, u.user_name,u.email " +
                " FROM pendientes p " +
                " LEFT JOIN users u ON p.user_name = u.user_name  " +
                " WHERE p.file_id = u.id_request AND u.id_request = p.file_id  ";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserAndPending.class));
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
