package com.constructor.constructorAPI.dtos.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CLIFORNEC")
public class CliFornec implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliFornec;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private double valor;
    private int diasQueTrabalha;
    private String descricao;


    public UUID getIdCliFornec() {
        return this.idCliFornec;
    }

    public void setIdCliFornec(UUID idCliFornec) {
        this.idCliFornec = idCliFornec;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDiasQueTrabalha() {
        return this.diasQueTrabalha;
    }

    public void setDiasQueTrabalha(int diasQueTrabalha) {
        this.diasQueTrabalha = diasQueTrabalha;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}