package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Distrito;

import java.util.List;

public interface DistritoService {
    public List<Distrito> listDistrito();
    public void createDistrito(Distrito distrito);
    public void deleteDistrito(Distrito distrito);
    /*public void updateDistrito(Distrito distrito);*/
    public Distrito findDistritoById(Distrito distrito);
    public List<Distrito> findDistritoByEstatusActivo();
}