package com.iunis.adventclub.service;

import com.iunis.adventclub.DomainKeys;
import com.iunis.adventclub.domain.Club;
import com.iunis.adventclub.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClubServiceImpl implements ClubService{

    @Autowired
    ClubRepository clubRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Club> listClub() {
        return (List<Club>) clubRepository.findAll();
    }

    @Override
    @Transactional
    public void createClub(Club club) {
        clubRepository.save(club);
    }

    @Override
    @Transactional
    public void deleteClub(Club club) {
        club.setEstatus(DomainKeys.ESTATUS_GENERAL_INACTIVO);
        clubRepository.save(club);
    }

    /*@Override
    @Transactional
    public void updateClub(Club club) {

    }*/


    @Override
    @Transactional(readOnly = true)
    public Club findClubById(Club club) {
        return clubRepository.findById(club.getId()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Club> findClubByEstatusActivo() {
        return clubRepository.findByEstatus(DomainKeys.ESTATUS_GENERAL_ACTIVO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Club> findClubesByIdIglesia(Long idIglesia) {
        return clubRepository.findClubesByIdIglesia(idIglesia);
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countActivos() {
        return clubRepository.countClubesActivos();
    }

}
