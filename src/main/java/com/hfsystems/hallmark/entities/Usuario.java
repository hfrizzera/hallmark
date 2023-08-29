package com.hfsystems.hallmark.entities;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.hfsystems.hallmark.dto.RequestPessoaDTO;
import com.hfsystems.hallmark.dto.RequestUsuarioDTO;
import com.hfsystems.hallmark.enums.TipoUsuario;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    private String foto;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public Usuario() {
    }

    public Usuario(RequestUsuarioDTO requestUsuarioDTO) {
        BeanUtils.copyProperties(requestUsuarioDTO, this);
    }

    public Usuario(Long id, String login, String senha, String foto, TipoUsuario tipo, Pessoa pessoa) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.foto = foto;
        this.tipo = tipo;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
