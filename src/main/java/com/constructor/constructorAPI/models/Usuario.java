package com.constructor.constructorAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "O nome não pode ser nulo")
    private String nome;
    @NotEmpty(message = "O email não pode ser nulo")
    private String email;
    private String telefone;
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