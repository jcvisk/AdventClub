package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Iglesia;

import java.util.List;

public interface IglesiaService {
    public List<Iglesia> listIglesia();
    public void createIglesia(Iglesia iglesia);
    public void deleteIglesia(Iglesia iglesia);
    /*public void updateIglesia(Iglesia iglesia);*/
    public Iglesia findIglesiaById(Iglesia iglesia);
    public List<Iglesia> findIglesiaByEstatusActivo();
}
