package com.crud.card.service;

import com.crud.card.modelo.Pendientes;
import com.crud.card.repositorio.PendingInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PendingService implements IPendingService {
    @Autowired
    private PendingInterface pending;

    @Override
    public List<Pendientes> allPending(){
        List<Pendientes> list;
        try {
            list = pending.allPending();
        }catch (Exception res){
            throw res;
        }
        return list;
    }

    @Override
    public int save(Pendientes file) {
        int row;
        try {
            row = pending.save(file);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
    @Override
    public int update(Pendientes file) {
        int row;
        try {
            row = pending.update(file);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
    @Override
    public int approveFile(int id) {
        int row;
        try {
            row = pending.approveFile(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
