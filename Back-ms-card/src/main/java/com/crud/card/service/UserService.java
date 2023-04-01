package com.crud.card.service;

import com.crud.card.modelo.Card;
import com.crud.card.modelo.UserModel;
import com.crud.card.repositorio.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserInterface {
    @Autowired
    private UserInterface User;

    @Override
    public List<UserModel> AllUsers() {
        List<UserModel> list;
        try {
            list = User.AllUsers();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int saveUser(UserModel user) {
        int row;
        try {
            row = User.saveUser(user);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int updateUser(UserModel user) {
        int row;
        try {
            row = User.updateUser(user);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteUser(int id) {
        int row;
        try {
            row = User.deleteUser(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}


