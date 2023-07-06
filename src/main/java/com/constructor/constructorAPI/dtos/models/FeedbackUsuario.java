package com.constructor.constructorAPI.dtos.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_FEEDBACK_USUARIO")
public class FeedbackUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFeedback;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private int notaDeAvaliacao;
    private String nomeReclamante;
    private String comentario;

    public UUID getIdFeedback() {
        return this.idFeedback;
    }

    public void setIdFeedback(UUID idFeedback) {
        this.idFeedback = idFeedback;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getNotaDeAvaliacao() {
        return this.notaDeAvaliacao;
    }

    public void setNotaDeAvaliacao(int notaDeAvaliacao) {
        this.notaDeAvaliacao = notaDeAvaliacao;
    }

    public String getNomeReclamante() {
        return this.nomeReclamante;
    }

    public void setNomeReclamante(String nomeReclamante) {
        this.nomeReclamante = nomeReclamante;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}