package com.crud.card.modelo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_card;

    @Column
    private String name;

    @Column
    private String number;

    @Column
    private String type;

    @Column
    private int cvv;

    @Column
    private int status;

}
