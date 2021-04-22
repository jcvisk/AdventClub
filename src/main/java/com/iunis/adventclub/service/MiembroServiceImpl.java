package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.Miembro;
import com.iunis.adventclub.repository.MiembroRepository;
import com.iunis.adventclub.utilities.DateUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MiembroServiceImpl implements MiembroService{

    @Autowired
    MiembroRepository miembroRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Miembro> listMiembro() {
        return (List<Miembro>) miembroRepository.findAll();
    }

    @Override
    @Transactional
    public void createMiembro(Miembro miembro) {
        miembro.getDatospersonales().setEdad(DateUtilities.calcEdadByFechaNac(miembro.getDatospersonales().getFechanacimiento()));
        miembroRepository.save(miembro);
    }

    @Override
    @Transactional
    public void deleteMiembro(Miembro miembro) {
        miembro.setEstatus(DomainKeys.ESTATUS_GENERAL_INACTIVO);
        miembroRepository.save(miembro);
    }

    /*@Override
    public void updateMiembro(Miembro miembro) {

    }*/

    @Override
    @Transactional(readOnly = true)
    public Miembro findMiembroById(Miembro miembro) {
        return miembroRepository.findById(miembro.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Miembro> findMiembroByEstatusActivo() {
        return miembroRepository.findByEstatus(DomainKeys.ESTATUS_GENERAL_ACTIVO);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countActivos() {
        return miembroRepository.countMiembrosActivos();
    }
}
