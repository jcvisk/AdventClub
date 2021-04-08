package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Periodoeclesiastico;

import java.util.List;

public interface PeriodoeclesiasticoService {
    public List<Periodoeclesiastico> listPeriodoeclesiastico();
    public void savePeriodoeclesiastico(Periodoeclesiastico periodoeclesiastico);
    public void deletePeriodoeclesiastico(Periodoeclesiastico periodoeclesiastico);
    public void updatePeriodoeclesiastico(Periodoeclesiastico periodoeclesiastico);
    public Periodoeclesiastico findPeriodoeclesiasticoById(Periodoeclesiastico periodoeclesiastico);
}
