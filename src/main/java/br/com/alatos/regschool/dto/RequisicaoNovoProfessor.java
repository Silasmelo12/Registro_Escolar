package br.com.alatos.regschool.dto;

import br.com.alatos.regschool.models.Professor;
import br.com.alatos.regschool.models.StatusProfessor;

import java.math.BigDecimal;

// é ua classe DTO (Data Transfer Object)
public class RequisicaoNovoProfessor {

    private String                     nome;
    private BigDecimal              salario;
    private StatusProfessor statusProfessor;

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusProfessor getStatusProfessor() {
        return statusProfessor;
    }

    public void setStatusProfessor(StatusProfessor statusProfessor) {
        this.statusProfessor = statusProfessor;
    }

    public Professor toProfessor(){
        Professor professor = new Professor();
        professor.setNome(this.nome);
        professor.setSalario(this.salario);
        professor.setStatusProfessor(this.statusProfessor);

        return professor;
    }
}
