package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Estatus;
import com.iunis.adventclub.domain.Iglesia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IglesiaRepository extends CrudRepository<Iglesia, Long> {
    List<Iglesia> findByEstatus(Estatus idEstatus);

    @Query(value = "SELECT * FROM iglesias WHERE iglesias.iddistrito = :idDistrito AND idestatus = 1", nativeQuery = true)
    List<Iglesia> findIglesiasByIdDistrito(@Param("idDistrito") Long idDistrito);
}
