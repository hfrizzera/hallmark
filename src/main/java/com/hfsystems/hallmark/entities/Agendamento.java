package com.hfsystems.hallmark.entities;

import com.hfsystems.hallmark.dto.RequestAgendamentoDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "TB_AGENDAMENTO")
public class Agendamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
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

    public Agendamento(Long id, Pessoa pessoa, Usuario usuario, Date dataAgendamento, String horaInicio, String horaFinal, BigDecimal valorTotalServico) {
        this.id = id;
        this.pessoa = pessoa;
        this.usuario = usuario;
        this.dataAgendamento = dataAgendamento;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.valorTotalServico = valorTotalServico;
    }

    public Agendamento(RequestAgendamentoDTO requestAgendamentoDTO){
        BeanUtils.copyProperties(requestAgendamentoDTO, this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
