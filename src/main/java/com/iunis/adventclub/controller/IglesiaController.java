package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Distrito;
import com.iunis.adventclub.domain.Iglesia;
import com.iunis.adventclub.service.DistritoService;
import com.iunis.adventclub.service.IglesiaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IglesiaController {

    @Autowired
    private IglesiaService iglesiaService;

    @Autowired
    private DistritoService distritoService;

    @GetMapping(value = "/iglesiaDisplay")
    public String display(Iglesia iglesia, Model model){
        //Obteniedo una lista de iglesias activas
        Iterable<Iglesia> igleiaList = iglesiaService.findIglesiaByEstatusActivo();
        model.addAttribute("iglesias", igleiaList);

        //Obteniedo una lista de distritos activos
        Iterable<Distrito> distritosList = distritoService.findDistritoByEstatusActivo();
        model.addAttribute("distritos", distritosList);

        //enviando iglesiaUpdate vacia solo para evitar error en el modal de edicion
        model.addAttribute("iglesiaUpdate", iglesia);

        return "iglesia";
    }

    @PostMapping(value = "/iglesiaCreate")
    public String create(Iglesia iglesia){
        iglesiaService.createIglesia(iglesia);
        return "redirect:/iglesiaDisplay";
    }

    @GetMapping(value = "/iglesiaDelete")
    public String delete(Iglesia iglesia){
        iglesia = iglesiaService.findIglesiaById(iglesia);
        iglesiaService.deleteIglesia(iglesia);
        return "redirect:/iglesiaDisplay";
    }

    @GetMapping(value = "/iglesiaUpdate")
    public String editar(Iglesia iglesia, Iglesia idIglesia, Model model){
        //busca la igleia por medio del id y llena el objeto iglesiaFull
        Iglesia iglesiaFull = iglesiaService.findIglesiaById(iglesia);
        model.addAttribute("iglesiaUpdate", iglesiaFull);

        //Obteniedo una lista de distritos activos
        Iterable<Distrito> distritosList = distritoService.findDistritoByEstatusActivo();
        model.addAttribute("distritos", distritosList);

        //Obteniedo una lista de iglesias activas
        Iterable<Iglesia> igleiaList = iglesiaService.findIglesiaByEstatusActivo();
        model.addAttribute("iglesias", igleiaList);

        return "iglesia";
    }
}
