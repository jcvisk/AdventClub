package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Estatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstatusRepository extends CrudRepository<Estatus, Long> {
}
