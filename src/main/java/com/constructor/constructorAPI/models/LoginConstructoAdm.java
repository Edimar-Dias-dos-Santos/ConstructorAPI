package com.constructor.constructorAPI.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_LOGIN_CONSTRUCTO_ADM")
public class LoginConstructoAdm implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLogin;

    private String username;
    private String password;

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
}