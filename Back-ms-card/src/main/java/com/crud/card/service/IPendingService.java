package com.crud.card.service;

import com.crud.card.modelo.Pendientes;

import java.util.List;

public interface IPendingService {
    List<Pendientes> allPending();

    int save(Pendientes file);

    int update(Pendientes file);

    int approveFile(int id);
}
