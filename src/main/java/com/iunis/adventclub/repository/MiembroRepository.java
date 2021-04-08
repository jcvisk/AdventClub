package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Estatus;
import com.iunis.adventclub.domain.Miembro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MiembroRepository extends CrudRepository<Miembro, Long> {
    List<Miembro> findByEstatus(Estatus estatus);
}
