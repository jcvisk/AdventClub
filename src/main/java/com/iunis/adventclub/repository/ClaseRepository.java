package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Clase;
import com.iunis.adventclub.domain.Estatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClaseRepository extends CrudRepository<Clase, Long> {
    List<Clase> findByEstatus(Estatus estatus);
}
