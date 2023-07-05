package com.constructor.constructorAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import jakarta.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name = "TB_USUARIO_PERFIL_IMG")
public class UsuarioPerfilImg implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idUsuarioPerfilImg;

    private UUID idUsuario;

    private String url;

    public UUID getIdUsuarioPerfilImg() {
        return idUsuarioPerfilImg;
    }

    public void setIdUsuarioPerfilImg(UUID idUsuarioPerfilImg) {
        this.idUsuarioPerfilImg = idUsuarioPerfilImg;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UUID getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
         this.idUsuario = idUsuario;
    }
}