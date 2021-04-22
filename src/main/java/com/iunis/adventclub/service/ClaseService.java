package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Clase;
import com.iunis.adventclub.domain.Club;
import com.iunis.adventclub.domain.Miembro;

import java.util.List;

public interface ClaseService {
    public List<Clase> listClase();
    public void createClase(Clase clase);
    public void deleteClase(Clase clase);
    /*public void updateClase(Clase clase);*/
    public Clase findClaseById(Clase clase);
    public List<Clase> findClaseByEstatusActivo();
    public List<Clase> findClasesByIdClub(long idClub);
    public Integer countActivos();
}