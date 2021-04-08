package com.iunis.adventclub.controller;

import com.iunis.adventclub.service.MiembroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MiembroController {

    @Autowired
    MiembroService miembroService;

    @GetMapping(value = "/miembroDisplay")
    public String display(Model model){
        return "miembro";
    }
}
