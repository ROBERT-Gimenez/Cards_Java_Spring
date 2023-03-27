package com.crud.card.service;

import com.crud.card.modelo.Card;

import java.util.List;

public interface CardService {
    public List<Card> findAll();
    public int save(Card card);
    public int update(Card card);
    public int deleteById(int id);
}
