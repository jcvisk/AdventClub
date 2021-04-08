package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Estatus;
import com.iunis.adventclub.service.EstatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class EstatusController {
    @Autowired
    private EstatusService estatusService;

    @GetMapping(value = "/estatusDisplay")
    public String estatus(Model model){
        Iterable<Estatus> estatus = estatusService.listEstatus();
        model.addAttribute("estatus", estatus);
        return "index";
    }

    @GetMapping(value = "/agregar")
    public String agregar(Estatus estatus){
        return "modificar";
    }

    @PostMapping(value = "/guardar")
    public String guardar(@Valid Estatus estatus, Errors errores){
        if (errores.hasErrors()){
            return "modificar";
        }
        estatusService.saveEstatus(estatus);
        return "redirect:/estatusDisplay";
    }

    //Path Variable @GetMapping(value = "/editar/{id}")
    @GetMapping(value = "/editar")
    public String editar(Estatus estatus, Model model){
        estatus = estatusService.findEstatusById(estatus);
        model.addAttribute("estatus", estatus);
        return "modificar";
    }

    @GetMapping(value = "/eliminar")
    public String eliminar(Estatus estatus){
        estatusService.deleteEstatus(estatus);
        return "redirect:/";
    }
}
