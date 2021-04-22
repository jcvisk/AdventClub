package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Estatus;
import com.iunis.adventclub.domain.Iglesia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IglesiaRepository extends CrudRepository<Iglesia, Long> {
    List<Iglesia> findByEstatus(Estatus idEstatus);

    @Query(value = "SELECT * FROM iglesias WHERE iglesias.iddistrito = :idDistrito AND idestatus = 1", nativeQuery = true)
    List<Iglesia> findIglesiasByIdDistrito(@Param("idDistrito") Long idDistrito);

    @Query(value = "SELECT COUNT(*) FROM iglesias WHERE idestatus = 1",nativeQuery = true)
    Integer countIglesiasActivas();
}
