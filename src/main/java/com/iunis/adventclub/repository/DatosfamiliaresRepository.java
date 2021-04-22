package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Datosfamiliares;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosfamiliaresRepository extends CrudRepository<Datosfamiliares, Long> {
}
