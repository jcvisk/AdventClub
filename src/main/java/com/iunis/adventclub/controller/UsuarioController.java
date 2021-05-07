package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Usuario;
import com.iunis.adventclub.service.ClubService;
import com.iunis.adventclub.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClubService clubService;

    @GetMapping(value = "/usuarioDisplay")
    public String display(Usuario usuario, Model model){
        //Mandando la lista de usuarios
        Iterable<Usuario> usuarioList = usuarioService.listUsuario();
        model.addAttribute("usuarios", usuarioList);

        return "usuario";
    }

    @PostMapping(value = "/usuarioCreate")
    public String create(Usuario usuario){
        usuarioService.createUsuario(usuario);
        return "redirect:/usuarioDisplay";
    }
}
