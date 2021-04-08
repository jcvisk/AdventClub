package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
