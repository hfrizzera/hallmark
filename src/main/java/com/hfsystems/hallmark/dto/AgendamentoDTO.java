package com.hfsystems.hallmark.dto;

import com.hfsystems.hallmark.entities.Agendamento;
import com.hfsystems.hallmark.entities.Pessoa;
import com.hfsystems.hallmark.entities.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

public class AgendamentoDTO {
    private Long id;
    private Pessoa pessoa;
    private Usuario usuario;
    private Date dataAgendamento;
    private String horaInicio;
    private String horaFinal;
    private BigDecimal valorTotalServico;

    public AgendamentoDTO() {
    }

    public AgendamentoDTO(Agendamento agendamento) {
        BeanUtils.copyProperties(agendamento, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
