package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.Distrito;
import com.iunis.adventclub.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    DistritoRepository distritoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Distrito> listDistrito() {
        return (List<Distrito>) distritoRepository.findAll();
    }

    @Override
    @Transactional
    public void createDistrito(Distrito distrito) {
        distritoRepository.save(distrito);
    }

    @Override
    @Transactional
    public void deleteDistrito(Distrito distrito) {
        distrito.setEstatus(DomainKeys.ESTATUS_GENERAL_INACTIVO);
        distritoRepository.save(distrito);
    }

    /*@Override
    @Transactional
    public void updateDistrito(Distrito distrito) {

    }*/

    @Override
    @Transactional(readOnly = true)
    public Distrito findDistritoById(Distrito distrito) {
        return distritoRepository.findById(distrito.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Distrito> findDistritoByEstatusActivo() {
        return distritoRepository.findByEstatus(DomainKeys.ESTATUS_GENERAL_ACTIVO);
    }

    @Override
    public List<Distrito> findDistritosByIdAsociacion(Long idAsociacion) {
        return distritoRepository.findDistritosByIdAsociacion(idAsociacion);
    }

}
