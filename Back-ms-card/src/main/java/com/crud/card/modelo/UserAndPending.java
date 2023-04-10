package com.crud.card.modelo;

import lombok.Data;

import java.time.LocalDate;


@Data
public class UserAndPending {
    private int file_id;
    private String user_name;
    private String type_request;
    private LocalDate date_created;
    private String status;
    private String email;

}
