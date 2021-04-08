/*
package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Club;
import com.iunis.adventclub.domain.Estatus;
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
public class TestCrud {

    @Autowired
    private ClubService clubService;

    @Autowired
    IglesiaService iglesiaService;

    @GetMapping(value = "/js")
    public String js() {
        return "JS";
    }

    @GetMapping(value = "/testCrudDisplay")
    public String display(Model model) {
        */
/*Iterable<Club> club =  clubService.listClub();
        model.addAttribute("clubes", club);*//*


        //Obteniedo una lista de clubes activos
        Iterable<Club> clubList = clubService.findClubByEstatusActivo();
        model.addAttribute("clubes", clubList);

        return "view";
    }

    @GetMapping(value = "/testCrudagregar")
    public String agregar(Club club, Model model){

        Iterable<Iglesia> igleiaList = iglesiaService.listIglesia();
        model.addAttribute("iglesias", igleiaList);

        return "create";
    }

    @PostMapping(value = "/testCrudCreate")
    public String create(Club club){
        clubService.createClub(club);
        return "redirect:/testCrudDisplay";
    }

    */
/**
     *
     * @param clublleno id del club a editar
     * @param model
     * @return
     *//*

    @GetMapping(value = "/testCrudEditar")
    public String editar(Club clublleno, Model model){

        clublleno = clubService.findClubById(clublleno);
        model.addAttribute("clubE", clublleno);

        Iterable<Iglesia> igleiaList = iglesiaService.listIglesia();
        model.addAttribute("iglesias", igleiaList);

        return "create";
    }

    @GetMapping(value = "/testCrudDelete")
    public String delete(Club club){
        //el objeto club ya viene lleno

        club = clubService.findClubById(club);
        clubService.deleteClub(club);

        return "redirect:/testCrudDisplay";
    }
}
*/
