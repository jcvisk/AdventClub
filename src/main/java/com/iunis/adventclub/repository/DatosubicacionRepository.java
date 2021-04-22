package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Datosubicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosubicacionRepository extends CrudRepository<Datosubicacion, Long> {
}
