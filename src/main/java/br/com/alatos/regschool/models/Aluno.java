package br.com.alatos.regschool.models;

import javax.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String nome;
    @Column(nullable = false)
    String ano;
    @Column(nullable = false)
    int idade;

    public Aluno() {
    }

    public Aluno(Long id, String nome, String ano, int idade) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
