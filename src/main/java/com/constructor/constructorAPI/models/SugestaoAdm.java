package com.constructor.constructorAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SUGESTAO_ADM")
public class SugestaoAdm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSugestaoAdm;
    private String nome;
    private String descricao;

    public Long getIdSugestaoAdm() {
        return idSugestaoAdm;
    }

    public void setIdSugestaoAdm(Long idSugestaoAdm) {
        this.idSugestaoAdm = idSugestaoAdm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}