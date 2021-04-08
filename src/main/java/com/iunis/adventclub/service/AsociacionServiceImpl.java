package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.Asociacion;
import com.iunis.adventclub.domain.Datosadministracion;
import com.iunis.adventclub.domain.Estatus;
import com.iunis.adventclub.repository.AsociacionRepository;
import com.iunis.adventclub.repository.DatosadministracionRepository;
import com.iunis.adventclub.repository.EstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AsociacionServiceImpl implements AsociacionService{

    @Autowired
    AsociacionRepository asociacionRepository;

    @Autowired
    DatosadministracionRepository datosadministracionRepository;

    @Autowired
    EstatusRepository estatusRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Asociacion> listAsociacion() {
        return (List<Asociacion>) asociacionRepository.findAll();
    }

    @Override
    @Transactional
    public void createAsociacion(Asociacion asociacion) {
        asociacionRepository.save(asociacion);
    }

    @Override
    @Transactional
    public void deleteAsociacion(Asociacion asociacion) {
        asociacion.setEstatus(DomainKeys.ESTATUS_GENERAL_INACTIVO);
        asociacionRepository.save(asociacion);
    }

    /*@Override
    @Transactional
    public void updateAsociacion(Asociacion asociacion) {

    }*/

    @Override
    @Transactional(readOnly = true)
    public Asociacion findAsociacionById(Asociacion asociacion) {
        return asociacionRepository.findById(asociacion.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Asociacion> findAsociacionByEstatusActivo() {
        return asociacionRepository.findByEstatus(DomainKeys.ESTATUS_GENERAL_ACTIVO);
    }
}
