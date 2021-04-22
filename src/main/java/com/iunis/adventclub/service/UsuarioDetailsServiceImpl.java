package com.iunis.adventclub.service;

import com.iunis.adventclub.domain.Rol;
import com.iunis.adventclub.domain.Usuario;
import com.iunis.adventclub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //buscar el usuario con el repositorio
        Usuario usuario = usuarioRepository.findUsuarioByUsuario(userName).orElseThrow(()-> new UsernameNotFoundException("ERROR: no existe el usuario"));

        //Mapear nuestra lista de roles con la de SpringSecurity
        List grandList = new ArrayList();

        for (Rol rol: usuario.getRol()){
            //ROLE_USER, ROLE_ADMIN
            GrantedAuthority grantedAuthority= new SimpleGrantedAuthority(rol.getDescripcion());
            grandList.add(grantedAuthority);
        }

        //Crear el objeto UserDetail
        UserDetails userDetails = (UserDetails) new User(usuario.getUsuario(), usuario.getPassword(), grandList);

        return userDetails;
    }
}
