package br.com.alatos.regschool.dto;

import br.com.alatos.regschool.models.Professor;
import br.com.alatos.regschool.models.StatusProfessor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

// é ua classe DTO (Data Transfer Object)
public class RequisicaoNovoProfessor {
    @NotNull
    @NotBlank
    private String nome;
    @DecimalMin(value = "0.0",inclusive = false)
    @NotNull
    private BigDecimal salario;
    @NotNull
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
