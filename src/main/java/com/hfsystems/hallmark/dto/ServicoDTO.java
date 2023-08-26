package com.hfsystems.hallmark.dto;

import com.hfsystems.hallmark.entities.Servico;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

public class ServicoDTO {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private String horaServico;

    public ServicoDTO() {
    }

    public ServicoDTO(Servico servico){
        BeanUtils.copyProperties(servico, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getHoraServico() {
        return horaServico;
    }

    public void setHoraServico(String horaServico) {
        this.horaServico = horaServico;
    }
}
