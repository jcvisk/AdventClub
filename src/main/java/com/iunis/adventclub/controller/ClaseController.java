package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Clase;
import com.iunis.adventclub.domain.Club;
import com.iunis.adventclub.service.ClaseService;
import com.iunis.adventclub.service.ClubService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @Autowired
    private ClubService clubService;

    @GetMapping(value = "/claseDisplay")
    public String display(Clase clase,Model model){
        //Obteniedo una lista de clases activas
        Iterable<Clase> claseList = claseService.findClaseByEstatusActivo();
        model.addAttribute("clases", claseList);

        //Obteniedo una lista de clubes activos
        Iterable<Club> clubList = clubService.findClubByEstatusActivo();
        model.addAttribute("clubes", clubList);
        //enviando claseUpdate vacio solo para evitar error en el modal de edicion
        model.addAttribute("claseUpdate", clase);

        return "clase";
    }

    @PostMapping(value = "/claseCreate")
    public String create(Clase clase){
        claseService.createClase(clase);
        return "redirect:/claseDisplay";
    }

    @GetMapping(value = "/claseDelete")
    public String delete(Clase clase){
        clase = claseService.findClaseById(clase);
        claseService.deleteClase(clase);

        return "redirect:/claseDisplay";
    }

    @GetMapping(value = "/claseUpdate")
    public String update(Clase clase, Clase idClase, Model model){
        Clase claseFull = claseService.findClaseById(idClase);
        model.addAttribute("claseUpdate", claseFull);

        //Obteniedo una lista de clases activas
        Iterable<Clase> claseList = claseService.findClaseByEstatusActivo();
        model.addAttribute("clases", claseList);

        //Obteniedo una lista de clubes activos
        Iterable<Club> clubList = clubService.findClubByEstatusActivo();
        model.addAttribute("clubes", clubList);

        return "clase";
    }

}
