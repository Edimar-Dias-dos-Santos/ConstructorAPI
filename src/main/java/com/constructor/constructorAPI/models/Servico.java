package com.constructor.constructorAPI.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_SERVICO")
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idServico;

    private String nomeServico;

    public UUID getIdServico() {
        return this.idServico;
    }

    public void setIdServico(UUID idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return this.nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }
}