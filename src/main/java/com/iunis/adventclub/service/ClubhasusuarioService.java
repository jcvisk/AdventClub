package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Clubhasusuario;

import java.util.List;

public interface ClubhasusuarioService {
    public List<Clubhasusuario> listClubhasusuario();
    public void saveClubhasusuario(Clubhasusuario clubhasusuario);
    public void deleteClubhasusuario(Clubhasusuario clubhasusuario);
    public void updateClubhasusuario(Clubhasusuario clubhasusuario);
    public Clubhasusuario findClubhasusuarioById(Clubhasusuario clubhasusuario);
}
