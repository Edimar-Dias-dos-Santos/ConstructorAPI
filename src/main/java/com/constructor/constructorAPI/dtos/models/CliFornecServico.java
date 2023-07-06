package com.constructor.constructorAPI.dtos.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CLIFORNEC_SERVICO")
public class CliFornecServico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCliFornecServico;

    @ManyToOne
    @JoinColumn(name = "idServico")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "idCliFornec")
    private CliFornec cliFornec;

    public UUID getIdCliFornecServico() {
        return this.idCliFornecServico;
    }

    public void setIdCliFornecServico(UUID idCliFornecServico) {
        this.idCliFornecServico = idCliFornecServico;
    }

    public Servico getServico() {
        return this.servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public CliFornec getCliFornec() {
        return this.cliFornec;
    }

    public void setCliFornec(CliFornec cliFornec) {
        this.cliFornec = cliFornec;
    }
}