package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Datospersonales;

import java.util.List;

public interface DatospersonalesService {
    public List<Datospersonales> listDatospersonales();
    public void saveDatospersonales(Datospersonales datospersonales);
    public void deleteDatospersonales(Datospersonales datospersonales);
    public void updateDatospersonales(Datospersonales datospersonales);
    public Datospersonales findById(Datospersonales datospersonales);
}
