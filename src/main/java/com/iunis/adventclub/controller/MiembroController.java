package com.iunis.adventclub.controller;

import com.iunis.adventclub.domain.Miembro;
import com.iunis.adventclub.service.MiembroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MiembroController {
    /**
     * Informacion que se necesita
     * Nombre del club
     * DatosPersonales
     * DatoUbicacion
     * DatosFamiliares
     * Clase
     */

    @Autowired
    MiembroService miembroService;

    @GetMapping(value = "/miembroDisplay")
    public String display(Model model){
        return "miembro";
    }

    @PostMapping(value = "/miembroCreate")
    public String create(Miembro miembro){
        //miembroService.
        return "miembro";
    }

}
