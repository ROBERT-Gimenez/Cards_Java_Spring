package com.crud.card.repositorio;

import com.crud.card.modelo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserRepo implements UserInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserModel> AllUsers(){
        String SQL = "SELECT * From users ";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(UserModel.class));
    }
   @Override
    public int saveUser(UserModel user){
        String SQL = "INSERT INTO users (userName, email , password) Values (?,?,?)";
        return jdbcTemplate.update(SQL,new Object[]{user.getUserName() , user.getEmail() , user.getPassword()});
    }
    @Override
    public int updateUser(UserModel user){
        String SQL = "UPDATE users SET userName=? , email=? , password=? WHERE id_user = ?";
        return jdbcTemplate.update(SQL,new Object[]{user.getUserName() , user.getEmail() , user.getPassword()});
    }
    @Override
    public UserModel findByEmail(String email) {
        String SQL = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{email}, BeanPropertyRowMapper.newInstance(UserModel.class));
    }
    @Override
    public int deleteUser(int id) {
        String SQL = "DELETE FROM users WHERE id_card = ?";
        return jdbcTemplate.update(SQL,new Object[]{id});
    }
}
