package br.com.alatos.regschool.controllers;

import br.com.alatos.regschool.dto.RequisicaoNovoAluno;
import br.com.alatos.regschool.models.Aluno;
import br.com.alatos.regschool.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("alunos")
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;
    @GetMapping
    public ModelAndView indexAlunos(){
        List<Aluno> listaAlunos = this.alunoRepository.findAll();
        ModelAndView mv = new ModelAndView("alunos/indexAlunos");
        return mv;
    }
    @GetMapping(path = "/newAluno")
    public ModelAndView novoAluno(RequisicaoNovoAluno requisicaoNovoAluno){
        ModelAndView mv = new ModelAndView("alunos/newAlunos");
        mv.addObject("requisicaoNovoAluno",requisicaoNovoAluno);
        return mv;
    }

}
