package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Estatus;

import java.util.List;

public interface EstatusService {
    public List<Estatus> listEstatus();
    public void saveEstatus(Estatus estatus);
    public void deleteEstatus(Estatus estatus);
    public void UpdateEstatus(Estatus estatus);
    public Estatus findEstatusById(Estatus estatus);
}
