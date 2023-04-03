package com.crud.card.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

@Data
public class UserModel {
    @JsonIgnore
    int id_user;
    String userName;
    String email;
    String password;
    public void setPassword(String password) {
        this.password = DigestUtils.sha256Hex(password);
    }
}
