package br.com.alatos.regschool.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequisicaoNovoAluno {

    @NotNull
    @NotBlank
    String nome;
    @NotNull
    @NotBlank
    String ano;
    @NotNull
    int idade;
}
