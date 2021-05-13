package com.iunis.adventclub.controller;

import com.iunis.adventclub.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class DashboardController {
    @Autowired
    AsociacionService asociacionService;
    @Autowired
    DistritoService distritoService;
    @Autowired
    IglesiaService iglesiaService;
    @Autowired
    ClubService clubService;
    @Autowired
    ClaseService claseService;
    @Autowired
    MiembroService miembroService;
    @Autowired
    PeriodoeclesiasticoService periodoService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping({"/","/login"})
    public String login(){
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboardAdmin(Model model){
        model.addAttribute("countAsociaicones", asociacionService.countActivos());
        model.addAttribute("countDistritos",distritoService.countActivos());
        model.addAttribute("countIglesias",iglesiaService.countActivos());
        model.addAttribute("countClubes",clubService.countActivos());
        model.addAttribute("countClases",claseService.countActivos());
        model.addAttribute("countMiembros",miembroService.countActivos());
        model.addAttribute("countPeriodos", periodoService.countActivos());
        model.addAttribute("countUsuarios", usuarioService.countUsuariosActivos());
        return "index";
    }
}
