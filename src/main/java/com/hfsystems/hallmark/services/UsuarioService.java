package com.hfsystems.hallmark.services;

import com.hfsystems.hallmark.dto.RequestUsuarioDTO;
import com.hfsystems.hallmark.dto.UsuarioDTO;
import com.hfsystems.hallmark.entities.Usuario;
import com.hfsystems.hallmark.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll(){
        return usuarioRepository.findAll().stream().map(x -> new UsuarioDTO(x)).toList();
    }

    public Usuario salvarUsuario(RequestUsuarioDTO requestUsuarioDTO){
        Usuario usuario = new Usuario(requestUsuarioDTO);
        return usuarioRepository.save(usuario);
    }

    public Usuario alterarUsuario(RequestUsuarioDTO requestUsuarioDTO){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(requestUsuarioDTO.id());
        if(optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setLogin(requestUsuarioDTO.login());
            usuario.setSenha(requestUsuarioDTO.senha());
            usuario.setFoto(requestUsuarioDTO.foto());
            usuario.setTipo(requestUsuarioDTO.tipo());
            usuario.setPessoa(requestUsuarioDTO.pessoa());
            return usuario;
        }else{
            throw new RuntimeException("Usuário não encontrada!");
        }
    }

    public void deletaUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
