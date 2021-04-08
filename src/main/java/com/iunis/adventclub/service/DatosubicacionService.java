package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Datosubicacion;

import java.util.List;

public interface DatosubicacionService {
    public List<Datosubicacion> listDatosubicacion();
    public void saveDatosubicacion(Datosubicacion datosubicacion);
    public void deleteDatosubicacion(Datosubicacion datosubicacion);
    public void updateDatosubicacion(Datosubicacion datosubicacion);
    public Datosubicacion findDatosubicacionById(Datosubicacion datosubicacion);
}
