package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Club;
import com.iunis.adventclub.domain.Estatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClubRepository extends CrudRepository<Club, Long> {
    List<Club> findByEstatus(Estatus idEstatus);
}
