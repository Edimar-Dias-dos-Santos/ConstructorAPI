package com.constructor.constructorAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import jakarta.persistence.GenerationType;

import java.io.Serializable;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idUsuario;
    private String nome;
    private String eMail;
    private boolean permissao;


    public UUID getIdUsuario() {
        return this.idUsuario;
    }

    public String getNome() {
        return this.nome;
    }

    public String geteMail() {
        return this.eMail;
    }

    public boolean isPermissao() {
        return this.permissao;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }
}
