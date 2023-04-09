package com.crud.card.modelo;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pendientes")
@Data
public class Pendientes {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int file_id;

        @Column
        private String user_name;

        @Column
        private String type_request;

        @Column
        @CreationTimestamp
        private LocalDate date_created;

        @Column(columnDefinition = "varchar(255) default 'No leído'")
        private String status;

       public Pendientes() {
                this.date_created = LocalDate.now(); // asignar la fecha actual por defecto
                this.status = "No Visto"; // asignar "pendiente" por defecto
        }

    }


