package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Estatus;
import com.iunis.adventclub.domain.Miembro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MiembroRepository extends CrudRepository<Miembro, Long> {
    List<Miembro> findByEstatus(Estatus estatus);

    @Query(value = "SELECT COUNT(*) FROM miembros WHERE idestatus = 1",nativeQuery = true)
    Integer countMiembrosActivos();
}
