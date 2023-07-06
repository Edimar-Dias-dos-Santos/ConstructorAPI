package com.constructor.constructorAPI.dtos.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID idUsuario;
    private String nome;
    private String email;
    private String telefone;

    private String profissao;

    private String urlPerfil;

    public String getProfissao() {
        return this.profissao;
    }

    public String getUrlPerfil() {
        return this.urlPerfil;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setUrlPerfil(String urlPerfil) {
        this.urlPerfil = urlPerfil;
    }

    private boolean permissao;

    @OneToMany(mappedBy = "usuario")
    private List<CliFornec> cliFornecs;

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }

    public List<CliFornec> getCliFornecs() {
        return cliFornecs;
    }

    public void setCliFornecs(List<CliFornec> cliFornecs) {
        this.cliFornecs = cliFornecs;
    }
}