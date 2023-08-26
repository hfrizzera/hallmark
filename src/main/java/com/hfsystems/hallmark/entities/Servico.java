package com.hfsystems.hallmark.entities;

import com.hfsystems.hallmark.dto.RequestServicoDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TB_SERVICO")
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal valor;
    @Column(name = "hora_servico")
    private String horaServico;

    public Servico() {
    }

    public Servico(RequestServicoDTO requestServicoDTO){
        BeanUtils.copyProperties(requestServicoDTO, this);
    }

    public Servico(Long id, String descricao, BigDecimal valor, String horaServico) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.horaServico = horaServico;
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

    public void setHoraServico(String hora_servico) {
        this.horaServico = hora_servico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(id, servico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
