package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.Iglesia;
import com.iunis.adventclub.repository.IglesiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IglesiaServiceImpl implements IglesiaService{

    @Autowired
    IglesiaRepository iglesiaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Iglesia> listIglesia() {
        return (List<Iglesia>) iglesiaRepository.findAll();
    }

    @Override
    @Transactional
    public void createIglesia(Iglesia iglesia) {
        iglesiaRepository.save(iglesia);
    }

    @Override
    @Transactional
    public void deleteIglesia(Iglesia iglesia) {
        iglesia.setEstatus(DomainKeys.ESTATUS_GENERAL_INACTIVO);
        iglesiaRepository.save(iglesia);
    }

    /*@Override
    @Transactional
    public void updateIglesia(Iglesia iglesia) {

    }*/

    @Override
    @Transactional(readOnly = true)
    public Iglesia findIglesiaById(Iglesia iglesia) {
        return iglesiaRepository.findById(iglesia.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Iglesia> findIglesiaByEstatusActivo() {
        return iglesiaRepository.findByEstatus(DomainKeys.ESTATUS_GENERAL_ACTIVO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Iglesia> findIglesiasByIdDistrito(Long idDistrito) {
        return iglesiaRepository.findIglesiasByIdDistrito(idDistrito);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countActivos() {
        return iglesiaRepository.countIglesiasActivas();
    }

}
