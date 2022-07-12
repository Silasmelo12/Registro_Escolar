package br.com.alatos.regschool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller//agora os métodos serão actions,(ações que serão realizadas (mappeadas) para cada url que desejamos realizar)
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello-request")
    public String helloRequest(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("nome","Silas");
        return "hello";
    }

    @GetMapping("/hello-model")
    public ModelAndView relloModel(){
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("nome","Mayara");
        return mv;
    }

}
