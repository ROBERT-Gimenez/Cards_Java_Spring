package com.crud.card.repositorio;

import com.crud.card.modelo.UserModel;

import java.util.List;

public interface UserInterface {
    public List<UserModel> AllUsers();

    public int saveUser(UserModel user);
    public int updateUser(UserModel user);
    public int deleteUser(int id);
}
