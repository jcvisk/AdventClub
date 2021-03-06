package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Club;
import com.iunis.adventclub.domain.Estatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends CrudRepository<Club, Long> {
    List<Club> findByEstatus(Estatus idEstatus);

    @Query(value = "SELECT * FROM clubes WHERE clubes.idiglesia = :idIglesia AND idestatus = 1", nativeQuery = true)
    List<Club> findClubesByIdIglesia(@Param("idIglesia") Long idIglesia);

    @Query(value = "SELECT COUNT(*) FROM clubes WHERE idestatus = 1",nativeQuery = true)
    Integer countClubesActivos();
}
