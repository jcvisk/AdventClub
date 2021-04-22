package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.Periodoeclesiastico;
import com.iunis.adventclub.repository.PeriodoeclesiasticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PeriodoeclesiasticoServiceImpl implements PeriodoeclesiasticoService{

    @Autowired
    PeriodoeclesiasticoRepository periodoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Periodoeclesiastico> listPeriodo() {
        return null;
    }

    @Override
    @Transactional
    public void createPeriodo(Periodoeclesiastico periodo) {
        periodoRepository.save(periodo);
    }

    @Override
    @Transactional
    public void deletePeriodo(Periodoeclesiastico periodo) {
        periodo.setEstatus(DomainKeys.ESTATUS_GENERAL_INACTIVO);
        periodoRepository.save(periodo);
    }

    @Override
    @Transactional(readOnly = true)
    public Periodoeclesiastico findPeriodoById(Periodoeclesiastico periodo) {
        return periodoRepository.findById(periodo.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Periodoeclesiastico> findPeriodoByEstatusActivo() {
        return periodoRepository.findByEstatus(DomainKeys.ESTATUS_GENERAL_ACTIVO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Periodoeclesiastico> findFechasByIdClub(Long idClub) {
        return periodoRepository.findFechasByIdClub(idClub);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countActivos() {
        return null;
    }
}
