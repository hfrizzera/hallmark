package com.hfsystems.hallmark.dto;

import com.hfsystems.hallmark.entities.Pessoa;
import com.hfsystems.hallmark.entities.Usuario;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {

    private Long id;
    private String login;
    private String senha;
    private String foto;
    private Pessoa pessoa;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario){
        BeanUtils.copyProperties(usuario, this);
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
