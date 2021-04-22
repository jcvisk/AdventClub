package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Clase;
import com.iunis.adventclub.domain.Estatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaseRepository extends CrudRepository<Clase, Long> {
    List<Clase> findByEstatus(Estatus estatus);

    //buscar clases por el id del club
    @Query(value = "select * from clases WHERE clases.idclub = :idClub AND clases.idestatus = 1",nativeQuery = true)
    List<Clase> findClasesByIdClub(@Param("idClub") Long idClub);

    @Query(value = "SELECT COUNT(*) FROM clases WHERE idestatus = 1",nativeQuery = true)
    Integer countClasesActivas();
}