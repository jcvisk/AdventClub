package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Clase;

import java.util.List;

public interface ClaseService {
    public List<Clase> listClase();
    public void createClase(Clase clase);
    public void deleteClase(Clase clase);
    /*public void updateClase(Clase clase);*/
    public Clase findClaseyId(Clase clase);
    public List<Clase> findClaseByEstatusActivo();
}