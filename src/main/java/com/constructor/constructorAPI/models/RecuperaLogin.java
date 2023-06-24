package com.constructor.constructorAPI.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_RECUPERA_LOGIN")
public class RecuperaLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idRecuperaLogin;
    private String cpf;
    private String dataNascimento;
    private String ultimoNome;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public UUID getIdRecuperaLogin() {
        return this.idRecuperaLogin;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String getUltimoNome() {
        return this.ultimoNome;
    }

    public void setIdRecuperaLogin(UUID idRecuperaLogin) {
        this.idRecuperaLogin = idRecuperaLogin;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}