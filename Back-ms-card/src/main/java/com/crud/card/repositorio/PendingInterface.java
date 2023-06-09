package com.crud.card.repositorio;

import com.crud.card.modelo.Pendientes;
import com.crud.card.modelo.UserAndPending;

import java.util.List;

public interface PendingInterface {

    public List<Pendientes> allPending();
    public List<UserAndPending> prueba();


    public List<Pendientes> allApproved();

    public int save(Pendientes file);

    public int update(Pendientes file);

    public int approveFile(int id);

}
