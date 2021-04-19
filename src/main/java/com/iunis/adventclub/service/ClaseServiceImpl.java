package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.Clase;
import com.iunis.adventclub.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClaseServiceImpl implements ClaseService{

    @Autowired
    ClaseRepository claseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Clase> listClase() {
        return (List<Clase>) claseRepository.findAll();
    }

    @Override
    @Transactional
    public void createClase(Clase clase) {
        claseRepository.save(clase);
    }

    @Override
    @Transactional
    public void deleteClase(Clase clase) {
        clase.setEstatus(DomainKeys.ESTATUS_GENERAL_INACTIVO);
        claseRepository.save(clase);
    }

    /*@Override
    public void updateClase(Clase clase) {

    }*/

    @Override
    @Transactional(readOnly = true)
    public Clase findClaseById(Clase clase) {
        return claseRepository.findById(clase.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clase> findClaseByEstatusActivo() {
        return claseRepository.findByEstatus(DomainKeys.ESTATUS_GENERAL_ACTIVO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Clase> findClasesByIdClub(long idClub){
        return claseRepository.findClasesByIdClub(idClub);
    }
}
