package com.introduccion.springott.web.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@GetMapping({" ", "/","/home"})
public String getMethodName( String param) {
    //return "redirect:/lista";
    return "forward:/detalles";
}

}