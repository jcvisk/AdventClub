package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Estatus;
import com.iunis.adventclub.repository.EstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstatusServiceImpl implements EstatusService{

    @Autowired
    EstatusRepository estatusRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Estatus> listEstatus() {
        return (List<Estatus>) estatusRepository.findAll();

    }

    @Override
    @Transactional
    public void saveEstatus(Estatus estatus) {
        estatusRepository.save(estatus);
    }

    @Override
    @Transactional
    public void deleteEstatus(Estatus estatus) {
        estatusRepository.delete(estatus);
    }

    @Override
    @Transactional
    public void UpdateEstatus(Estatus estatus) {

    }

    @Override
    public Estatus findEstatusById(Estatus estatus) {
        return estatusRepository.findById(estatus.getId()).orElse(null);
    }


}
