package com.iunis.adventclub.repository;

import com.iunis.adventclub.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    public Optional<Usuario> findUsuarioByUsuario(String nombre);
}
