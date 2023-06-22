package com.constructor.constructorAPI.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_LOGIN")
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID idUsuario;

    private String username;
    private String password;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
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
}