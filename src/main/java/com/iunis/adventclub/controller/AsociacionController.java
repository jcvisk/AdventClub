package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Asociacion;
import com.iunis.adventclub.service.AsociacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
public class AsociacionController {
    @Autowired
    private AsociacionService asociacionService;

    @GetMapping(value = "/asociacionDisplay")
    public String display(Asociacion asociacion, Model model){
        //Obteniendo una lista de asociaciones activas
        Iterable<Asociacion> asociacionesList = asociacionService.findAsociacionByEstatusActivo();
        model.addAttribute("asociaciones", asociacionesList);

        //enviando asociacionUpdate vacia solo para evitar error en el modal de edicion
        model.addAttribute("asociacionUpdate", asociacion);

        return "asociacion";
    }

    @PostMapping(value = "/asociacionCreate")
    public String create(@Valid Asociacion asociacion, Errors errores, Model model){
        if (errores.hasErrors()){
            //Obteniendo una lista de asociaciones activas
            Iterable<Asociacion> asociacionesList = asociacionService.findAsociacionByEstatusActivo();
            model.addAttribute("asociaciones", asociacionesList);

            //enviando asociacionUpdate vacia solo para evitar error en el modal de edicion
            model.addAttribute("asociacionUpdate", asociacion);

            return "asociacion";
        }else{
            asociacionService.createAsociacion(asociacion);
            return "redirect:/asociacionDisplay";
        }
    }

    @GetMapping(value = "/asociacionDelete")
    public String delete(Asociacion asociacion){
        asociacion = asociacionService.findAsociacionById(asociacion);
        asociacionService.deleteAsociacion(asociacion);
        return "redirect:/asociacionDisplay";
    }

    @GetMapping(value = "/asociacionUpdate")
    public String update(Asociacion asociacion, Asociacion idAsociacion,Model model){
        Asociacion asociacionfull = asociacionService.findAsociacionById(idAsociacion);
        model.addAttribute("asociacionUpdate", asociacionfull);

        //Obteniendo una lista de asociaciones
        Iterable<Asociacion> asociacionesList = asociacionService.findAsociacionByEstatusActivo();
        model.addAttribute("asociaciones", asociacionesList);

        return "asociacion";
    }


}
