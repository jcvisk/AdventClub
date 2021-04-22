package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Periodoeclesiastico;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeriodoeclesiasticoService {
    public List<Periodoeclesiastico> listPeriodo();
    public void createPeriodo(Periodoeclesiastico periodo);
    public void deletePeriodo(Periodoeclesiastico periodo);
    /*public void updatePeriodoeclesiastico(Periodoeclesiastico periodoeclesiastico);*/
    public Periodoeclesiastico findPeriodoById(Periodoeclesiastico periodo);
    public List<Periodoeclesiastico> findPeriodoByEstatusActivo();
    List<Periodoeclesiastico> findFechasByIdClub(Long idClub);
    public Integer countActivos();
}
