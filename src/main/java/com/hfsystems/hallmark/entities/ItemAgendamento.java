package com.hfsystems.hallmark.entities;

import com.hfsystems.hallmark.dto.RequestItemAgendamentoDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TB_ITEM_AGENDAMENTO")
public class ItemAgendamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "agendamento_id")
    private Agendamento agendamento;
    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;
    private String horaItem;
    private BigDecimal valorItem;

    public ItemAgendamento() {
    }

    public ItemAgendamento(Long id, Agendamento agendamento, Servico servico, String horaItem, BigDecimal valorItem) {
        this.id = id;
        this.agendamento = agendamento;
        this.servico = servico;
        this.horaItem = horaItem;
        this.valorItem = valorItem;
    }

    public ItemAgendamento(RequestItemAgendamentoDTO requestItemAgendamentoDTO){
        BeanUtils.copyProperties(requestItemAgendamentoDTO, this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemAgendamento that = (ItemAgendamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
