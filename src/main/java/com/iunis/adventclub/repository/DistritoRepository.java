package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Distrito;
import com.iunis.adventclub.domain.Estatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistritoRepository extends CrudRepository<Distrito, Long> {
    List<Distrito> findByEstatus(Estatus estatus);

    //buscar distritos por el id de la asociacion
    @Query(value = "SELECT * FROM distritos WHERE distritos.idasociacion = :idAsociacion AND idestatus = 1", nativeQuery = true)
    List<Distrito> findDistritosByIdAsociacion(@Param("idAsociacion") Long idAsociacion);

    @Query(value = "SELECT COUNT(*) FROM distritos WHERE idestatus = 1",nativeQuery = true)
    Integer countDistritosActivos();
}
