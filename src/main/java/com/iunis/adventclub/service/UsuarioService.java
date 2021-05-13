package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> listUsuario();
    public void createUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
    public void updateUsuario(Usuario usuario);
    public Usuario findUsuarioById(Usuario usuario);
    Integer countUsuariosActivos();
}
