package br.com.alatos.regschool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Professor {

    @GetMapping("/professores")
    public String index(){
        return "professores/index";
    }


}
