package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Club;
import com.iunis.adventclub.domain.Periodoeclesiastico;
import com.iunis.adventclub.service.ClubService;
import com.iunis.adventclub.service.PeriodoeclesiasticoService;
import com.iunis.adventclub.utilities.DateUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
@Slf4j
public class PeriodoController {

    @Autowired
    private PeriodoeclesiasticoService periodoService;
    @Autowired
    private ClubService clubService;

    @GetMapping(value = "/periodoDisplay")
    public String display(Periodoeclesiastico periodo, Model model){
        Iterable<Club> clubs = clubService.findClubByEstatusActivo();
        model.addAttribute("clubes", clubs);

        Iterable<Periodoeclesiastico> periodos = periodoService.findPeriodoByEstatusActivo();
        model.addAttribute("periodos", periodos);

        //mandando periodoUpdate para evitar error en el modal de edicion
        model.addAttribute("periodoUpdate", periodo);

        return "periodo";
    }

    @PostMapping(value = "/periodoCreate")
    public String create(Periodoeclesiastico periodo, Model model){
        Iterable<Club> clubs = clubService.findClubByEstatusActivo();

        //si la fecha de inicion es menor a la fecha de fin
        if(periodo.getInicioinscripcion().before(periodo.getFininscripcion())){
            Date fechaActual = new Date();

            //si la fecha fin es mayor o igual a la fecha actual
            if (periodo.getFininscripcion().after(fechaActual) || DateUtilities.dateToString(fechaActual).equals(DateUtilities.dateToString(periodo.getFininscripcion()))){
                periodoService.createPeriodo(periodo);
                return "redirect:/periodoDisplay";

            }else{
                model.addAttribute("clubes", clubs);
                model.addAttribute("ERROR", "La fecha de fin debe ser igual o mayor a la fecha de hoy");
            }

        }else{
            model.addAttribute("clubes", clubs);
            model.addAttribute("ERROR", "La fecha de inicio no puede ser mayor a la fecha de fin");
        }

        return "redirect:/periodoDisplay";
    }

    @GetMapping(value = "/periodoUpdate")
    public String update(Periodoeclesiastico periodo, Periodoeclesiastico idPeriodo, Model model){
        Periodoeclesiastico periodoFull = periodoService.findPeriodoById(idPeriodo);
        model.addAttribute("periodoUpdate", periodoFull);

        Iterable<Club> clubs = clubService.findClubByEstatusActivo();
        model.addAttribute("clubes", clubs);

        Iterable<Periodoeclesiastico> periodos = periodoService.findPeriodoByEstatusActivo();
        model.addAttribute("periodos", periodos);

        return "periodo";
    }

    @GetMapping(value = "/periodoDelete")
    public String delete(Periodoeclesiastico periodo){
        periodo = periodoService.findPeriodoById(periodo);
        periodoService.deletePeriodo(periodo);
        return "redirect:/periodoDisplay";
    }

}
