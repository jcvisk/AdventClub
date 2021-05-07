package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Usuario;
import com.iunis.adventclub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public void createUsuario(Usuario usuario) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        usuario.setUserpassword(bCryptPasswordEncoder.encode((usuario.getUserpassword())));

        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {

    }

    @Override
    public void updateUsuario(Usuario usuario) {

    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return null;
    }
}
