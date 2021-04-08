package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Asociacion;
import com.iunis.adventclub.domain.Estatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AsociacionRepository extends CrudRepository<Asociacion, Long> {
    List<Asociacion> findByEstatus(Estatus estatus);
}
