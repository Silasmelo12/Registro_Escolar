package br.com.alatos.regschool.controllers;

import br.com.alatos.regschool.dto.RequisicaoNovoProfessor;
import br.com.alatos.regschool.models.Professor;
import br.com.alatos.regschool.models.StatusProfessor;
import br.com.alatos.regschool.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("professores")
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping
    public ModelAndView index() {
        List<Professor> listaProfessores = this.professorRepository.findAll();// o erro 500 é aqui
        ModelAndView mv = new ModelAndView("professores/index");
        mv.addObject("listaProfessores", listaProfessores);
        return mv;
    }

    @GetMapping(path = "/new")
    public ModelAndView novo(RequisicaoNovoProfessor requisicaoNovoProfessor) {
        ModelAndView mv = new ModelAndView("professores/new");
        mv.addObject("listaStatusProfessor", StatusProfessor.values());
        return mv;
    }

    //bindingResult vem do @Valid que é o resultado do empacotamento
    @PostMapping
    public ModelAndView create(@Valid RequisicaoNovoProfessor requisicaoNovoProfessor, BindingResult bindingResult) {
        System.out.println("O que está vindo" + requisicaoNovoProfessor.getNome());

        if (bindingResult.hasErrors()) {
            System.out.println("Tem erros");
            ModelAndView mv = new ModelAndView("professores/new");
            mv.addObject("listaStatusProfessor", StatusProfessor.values());
            return mv;
        } else {
            Professor professor = requisicaoNovoProfessor.toProfessor();
            this.professorRepository.save(professor);
            return new ModelAndView("redirect:professores/"+professor.getId());
        }
    }
    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<Professor> optional = this.professorRepository.findById(id);
        if (optional.isPresent()){
            Professor professor = optional.get();
            ModelAndView mv = new ModelAndView("professores/show");
            mv.addObject("professor",professor);
            return mv;
        }else {
            System.out.println("Não achou nenhum optional com este Id");
            return new ModelAndView("redirect:");
        }
    }
}