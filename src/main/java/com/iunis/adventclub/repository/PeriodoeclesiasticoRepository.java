package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Estatus;
import com.iunis.adventclub.domain.Periodoeclesiastico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodoeclesiasticoRepository extends CrudRepository<Periodoeclesiastico, Long> {
    List<Periodoeclesiastico> findByEstatus(Estatus estatus);

    @Query(value = "select * from periodoeclesiastico WHERE periodoeclesiastico.idclub = :idClub",nativeQuery = true)
    List<Periodoeclesiastico> findFechasByIdClub(@Param("idClub") Long idClub);

    @Query(value = "SELECT COUNT(*) FROM periodoeclesiastico WHERE idestatus = 1",nativeQuery = true)
    Integer countPeriodosActivos();
}
