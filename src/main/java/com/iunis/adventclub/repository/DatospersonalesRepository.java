package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Datospersonales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatospersonalesRepository extends CrudRepository<Datospersonales, Long> {
}
