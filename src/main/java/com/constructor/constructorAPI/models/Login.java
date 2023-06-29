package com.constructor.constructorAPI.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_LOGIN")
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLogin;

    private String codigoLogado;

    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public UUID getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(UUID idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCodigoLogado() {
        return this.codigoLogado;
    }

    public void setCodigoLogado(String codigoLogado) {
        this.codigoLogado = codigoLogado;
    }
}