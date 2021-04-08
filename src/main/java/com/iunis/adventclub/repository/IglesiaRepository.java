package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Estatus;
import com.iunis.adventclub.domain.Iglesia;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IglesiaRepository extends CrudRepository<Iglesia, Long> {
    List<Iglesia> findByEstatus(Estatus idEstatus);
}
