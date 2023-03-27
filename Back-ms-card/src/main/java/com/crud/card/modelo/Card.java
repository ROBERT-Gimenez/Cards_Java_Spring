package com.crud.card.modelo;

import lombok.Data;

@Data
public class Card {
    int id_card;
    String name;
    String number;
    String type;
    int cvv;
    int status;

}
