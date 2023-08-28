package com.hfsystems.hallmark.dto;

import com.hfsystems.hallmark.entities.Agendamento;
import com.hfsystems.hallmark.entities.ItemAgendamento;
import com.hfsystems.hallmark.entities.Servico;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

public class ItemAgendamentoDTO {
    private Long id;
    private Agendamento agendamento;
    private Servico servico;
    private String horaItem;
    private BigDecimal valorItem;

    public ItemAgendamentoDTO() {
    }

    public ItemAgendamentoDTO(ItemAgendamento itemAgendamento){
        BeanUtils.copyProperties(itemAgendamento, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getHoraItem() {
        return horaItem;
    }

    public void setHoraItem(String horaItem) {
        this.horaItem = horaItem;
    }

    public BigDecimal getValorItem() {
        return valorItem;
    }

    public void setValorItem(BigDecimal valorItem) {
        this.valorItem = valorItem;
    }
}
