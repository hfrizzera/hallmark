package com.hfsystems.hallmark.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TB_AGENDAMENTO")
public class Agendamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_agendamento")
    private Date dataAgendamento;
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Column(name = "hora_final")
    private String horaFinal;
    @Column(name = "valor_total_servico")
    private BigDecimal valorTotalServico;

    public Agendamento() {
    }

    public Agendamento(Long id, Date dataAgendamento, String horaInicio, String horaFinal, BigDecimal valorTotalServico) {
        this.id = id;
        this.dataAgendamento = dataAgendamento;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.valorTotalServico = valorTotalServico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public BigDecimal getValorTotalServico() {
        return valorTotalServico;
    }

    public void setValorTotalServico(BigDecimal valorTotalServico) {
        this.valorTotalServico = valorTotalServico;
    }
}
