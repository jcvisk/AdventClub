package com.iunis.adventclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class DashboardController {
    @GetMapping(value = "/")
    public String display(){
        return "index";
    }
}
