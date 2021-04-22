package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Asociacion;
import com.iunis.adventclub.domain.Estatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsociacionRepository extends CrudRepository<Asociacion, Long> {
    List<Asociacion> findByEstatus(Estatus estatus);

    @Query(value = "SELECT COUNT(*) FROM asociaciones WHERE idestatus = 1",nativeQuery = true)
    Integer countAsociacionesActivas();
}
