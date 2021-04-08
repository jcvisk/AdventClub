package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Miembro;

import java.util.List;

public interface MiembroService {
    public List<Miembro> listMiembro();
    public void saveMiembro(Miembro miembro);
    public void deleteMiembro(Miembro miembro);
    /*public void updateMiembro(Miembro miembro);*/
    public Miembro findMiembroById(Miembro miembro);
    public List<Miembro> findMiembroByEstatusActivo();
}
