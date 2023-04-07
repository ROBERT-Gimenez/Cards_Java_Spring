package com.crud.card.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    int id_user;

    @Column
    String userName;

    @Column
    String email;

    @Column
    String password;


    public void setPassword(String password) {
        this.password = DigestUtils.sha256Hex(password);
    }
}
