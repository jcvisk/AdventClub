package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Datosadministracion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosadministracionRepository extends CrudRepository<Datosadministracion, Long> {
}
