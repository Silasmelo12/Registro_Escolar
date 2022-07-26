package br.com.alatos.regschool.controllers;

import br.com.alatos.regschool.dto.RequisicaoNovoProfessor;
import br.com.alatos.regschool.models.Professor;
import br.com.alatos.regschool.models.StatusProfessor;
import br.com.alatos.regschool.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;
    @GetMapping("/professores")
    public ModelAndView index(){
        List<Professor> listaProfessores = this.professorRepository.findAll();
        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("professor",listaProfessores);
        return mv;
    }

    //bindingResult vem do @Valid que é o resultado do empacotamento
    @PostMapping("/professores")
    public String create(@Valid RequisicaoNovoProfessor requisicaoNovoProfessor, BindingResult bindingResult){
        System.out.println("O que está vindo"+requisicaoNovoProfessor.getNome());

        if (bindingResult.hasErrors()){
            System.out.println("Tem erros");
            return "redirect:professores/new";
        }else{
            Professor professor = requisicaoNovoProfessor.toProfessor();
            this.professorRepository.save(professor);
            return "redirect:professores";
        }


    }

    @GetMapping("/professor/new")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("statusProfessor", StatusProfessor.values());
        return mv;
    }
}
