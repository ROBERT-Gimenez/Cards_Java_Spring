package com.crud.card.repositorio;

import com.crud.card.modelo.Pendientes;

import java.util.List;

public interface PendingInterface {

    public List<Pendientes> allPending();

    public int save(Pendientes file);

    public int update(Pendientes file);

    public int approveFile(int id);

}
