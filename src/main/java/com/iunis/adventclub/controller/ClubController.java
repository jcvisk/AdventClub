package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Club;
import com.iunis.adventclub.domain.Iglesia;
import com.iunis.adventclub.service.ClubService;
import com.iunis.adventclub.service.IglesiaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClubController {

    @Autowired
    ClubService clubService;

    @Autowired
    IglesiaService iglesiaService;

    @GetMapping(value = "/clubDisplay")
    public String display(Club club, Model model){
        //Obteniedo una lista de clubes activos
        Iterable<Club> clubList = clubService.findClubByEstatusActivo();
        model.addAttribute("clubes", clubList);

        //Obteniedo una lista de iglesias
        Iterable<Iglesia> igleiaList = iglesiaService.findIglesiaByEstatusActivo();
        model.addAttribute("iglesias", igleiaList);

        //enviando clubUpdate vacia solo para evitar error en el modal de edicion
        model.addAttribute("clubUpdate", club);

        return "club";
    }

    @PostMapping(value = "/clubCreate")
    public String create(Club club){
        clubService.createClub(club);
        return "redirect:/clubDisplay";
    }

    @GetMapping(value = "/clubDelete")
    public String update(Club club){
        //findClubById busca el objeto por id y lo llena en club
        club = clubService.findClubById(club);
        //cambia el id del estatus a inactivo
        clubService.deleteClub(club);
        //retorna a display
        return "redirect:/clubDisplay";
    }

    @GetMapping(value = "/clubUpdate")
    public String editar(Club club, Club idClub, Model model){
        //busca el club por medio del id y llena el objeto clubFull
        Club clubFull = clubService.findClubById(idClub);
        model.addAttribute("clubUpdate", clubFull);

        //Obteniedo una lista de iglesias
        Iterable<Iglesia> igleiaList = iglesiaService.findIglesiaByEstatusActivo();
        model.addAttribute("iglesias", igleiaList);

        //Obteniedo una lista de clubes activos
        Iterable<Club> clubList = clubService.findClubByEstatusActivo();
        model.addAttribute("clubes", clubList);

        return "club";
    }
}
