package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Datosfamiliares;

import java.util.List;

public interface DatosfamiliaresService {
    public List<Datosfamiliares> listDatosfamiliares();
    public void saveDatosfamiliares(Datosfamiliares datosfamiliares);
    public void deleteDatosfamiliares(Datosfamiliares datosfamiliares);
    public void updateDatosfamiliares(Datosfamiliares datosfamiliares);
    public Datosfamiliares findDatosfamiliaresById(Datosfamiliares datosfamiliares);
}
