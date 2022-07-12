package br.com.alatos.regschool.controllers;

import br.com.alatos.regschool.dto.RequisicaoNovoProfessor;
import br.com.alatos.regschool.models.Professor;
import br.com.alatos.regschool.models.StatusProfessor;
import br.com.alatos.regschool.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/professores")
    public String create(RequisicaoNovoProfessor requisicaoNovoProfessor){
        Professor professor = requisicaoNovoProfessor.toProfessor();
        this.professorRepository.save(professor);

        return "redirect:professores";
    }
    @GetMapping("/professor/new")
    public ModelAndView nnew(){

        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("statusProfessor", StatusProfessor.values());
        return mv;
    }
}
