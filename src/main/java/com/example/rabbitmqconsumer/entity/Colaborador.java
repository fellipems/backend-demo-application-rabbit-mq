package com.example.rabbitmqconsumer.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    @NotNull
    private String nome;

    @Column(name = "SENHA")
    @NotNull
    private String senha;

    @Column(name = "SCORE")
    private String score;

    @ManyToOne
    @JoinColumn(name = "ID_CHEFE")
    private Colaborador chefe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Colaborador getChefe() {
        return chefe;
    }

    public void setChefe(Colaborador chefe) {
        this.chefe = chefe;
    }
}
