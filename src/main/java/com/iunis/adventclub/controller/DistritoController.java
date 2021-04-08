package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Asociacion;
import com.iunis.adventclub.domain.Distrito;
import com.iunis.adventclub.service.AsociacionService;
import com.iunis.adventclub.service.DistritoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class DistritoController {
    @Autowired
    private DistritoService distritoService;

    @Autowired
    private AsociacionService asociacionService;

    @GetMapping(value = "/distritoDisplay")
    public String display(Distrito distrito, Model model){
        //Obteniedo una lista de distritos activos
        Iterable<Distrito> distritosList = distritoService.findDistritoByEstatusActivo();
        model.addAttribute("distritos", distritosList);

        //Obteniendo una lista de las asociaciones activas
        Iterable<Asociacion> asociacionesList = asociacionService.findAsociacionByEstatusActivo();
        model.addAttribute("asociaciones", asociacionesList);

        //enviando clubUpdate vacia solo para evitar error en el modal de edicion
        model.addAttribute("distritoUpdate", distrito);

        return "distrito";
    }

    @PostMapping(value = "/distritoCreate")
    public String create(Distrito distrito){
        distritoService.createDistrito(distrito);
        return "redirect:/distritoDisplay";
    }

    @GetMapping(value = "/distritoDelete")
    public String delete(Distrito distrito){
        distrito = distritoService.findDistritoById(distrito);
        distritoService.deleteDistrito(distrito);
        return "redirect:/distritoDisplay";
    }

    @GetMapping(value = "/distritoUpdate")
    public String editar(Distrito distrito, Distrito idDistrito, Model model){
        //busca el distrito por medio del id y llena el objeto distritoFull
        Distrito distritoFull = distritoService.findDistritoById(idDistrito);
        model.addAttribute("distritoUpdate", distritoFull);

        //Obteniendo una lista de las asociaciones activas
        Iterable<Asociacion> asociacionesList = asociacionService.findAsociacionByEstatusActivo();
        model.addAttribute("asociaciones", asociacionesList);

        //Obteniedo una lista de distritos activos
        Iterable<Distrito> distritosList = distritoService.findDistritoByEstatusActivo();
        model.addAttribute("distritos", distritosList);

        return "distrito";
    }
}
