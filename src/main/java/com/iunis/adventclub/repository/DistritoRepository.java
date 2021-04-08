package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Distrito;
import com.iunis.adventclub.domain.Estatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DistritoRepository extends CrudRepository<Distrito, Long> {
    List<Distrito> findByEstatus(Estatus estatus);
}
