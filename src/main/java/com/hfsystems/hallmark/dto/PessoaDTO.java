package com.hfsystems.hallmark.dto;

import com.hfsystems.hallmark.entities.Pessoa;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class PessoaDTO {
    private Long id;
    private String nome;
    private String telefone;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        BeanUtils.copyProperties(pessoa, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaDTO pessoaDTO = (PessoaDTO) o;
        return Objects.equals(id, pessoaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
