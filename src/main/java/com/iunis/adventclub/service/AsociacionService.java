package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Asociacion;

import java.util.List;

public interface AsociacionService {
    public List<Asociacion> listAsociacion();
    public void createAsociacion(Asociacion asociacion);
    public void deleteAsociacion(Asociacion asociacion);
    /*public void updateAsociacion(Asociacion asociacion);*/
    public Asociacion findAsociacionById(Asociacion asociacion);
    public List<Asociacion> findAsociacionByEstatusActivo();
}