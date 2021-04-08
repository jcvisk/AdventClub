package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Datosadministracion;

import java.util.List;

public interface DatosadministracionService {
    public List<Datosadministracion> listDatosadministracion();
    public void saveDatosadministracion(Datosadministracion datosadministracion);
    public void deleteDatosadministracion(Datosadministracion datosadministracion);
    public void updateDatosadministracion(Datosadministracion datosadministracion);
    public Datosadministracion findDatosadministracionById(Datosadministracion datosadministracion);
}
