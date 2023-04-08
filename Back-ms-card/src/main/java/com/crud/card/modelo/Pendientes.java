package com.crud.card.modelo;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pendientes")
@Data
public class Pendientes {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int file_id;

        @Column
        private String userName;

        @Column
        private String typeRequest;

        @Column
        @CreationTimestamp
        private LocalDate dateCreated;

        @Column
        private String status;

    }


