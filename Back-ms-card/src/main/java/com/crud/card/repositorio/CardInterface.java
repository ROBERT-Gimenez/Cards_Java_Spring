package com.crud.card.repositorio;

import com.crud.card.modelo.Card;

import java.util.List;

public interface CardInterface {
    public List<Card> fiendAll();
    public int save(Card card);
    public int update(Card card);
    public int deleteById(int id);
}
