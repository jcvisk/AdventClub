package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Club;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClubService {
    public List<Club> listClub();
    public void createClub(Club club);
    public void deleteClub(Club club);
    /*public void updateClub(Club club);*/
    public Club findClubById(Club club);
    public List<Club> findClubByEstatusActivo();
    List<Club> findClubesByIdIglesia(Long idIglesia);
    Integer countActivos();
}