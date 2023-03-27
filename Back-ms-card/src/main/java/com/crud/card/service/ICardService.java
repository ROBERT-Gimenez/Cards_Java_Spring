package com.crud.card.service;

import com.crud.card.modelo.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.card.repositorio.RepoCard;

import java.util.List;

@Service//con esto indicamos que esta clase es un servicio que se va a poder inyectar al controller
public class ICardService implements CardService {

    @Autowired
    private RepoCard repoCard;

    @Override
    public List<Card> findAll() {
        List<Card> list;
        try {
            list = repoCard.fiendAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Card card) {
        int row;
        try {
            row = repoCard.save(card);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Card card) {
        int row;
        try {
            row = repoCard.update(card);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try {
            row = repoCard.deleteById(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
