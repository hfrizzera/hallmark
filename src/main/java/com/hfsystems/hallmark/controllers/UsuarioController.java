package com.hfsystems.hallmark.controllers;

import com.hfsystems.hallmark.dto.PessoaDTO;
import com.hfsystems.hallmark.dto.RequestPessoaDTO;
import com.hfsystems.hallmark.dto.RequestUsuarioDTO;
import com.hfsystems.hallmark.dto.UsuarioDTO;
import com.hfsystems.hallmark.entities.Pessoa;
import com.hfsystems.hallmark.entities.Usuario;
import com.hfsystems.hallmark.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public UsuarioDTO findById(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @GetMapping
    public List<UsuarioDTO> findAll(){
        return usuarioService.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid RequestUsuarioDTO requestUsuarioDTO){
        return ResponseEntity.ok(usuarioService.salvarUsuario(requestUsuarioDTO));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Usuario> alterarUsuario(@RequestBody @Valid RequestUsuarioDTO requestUsuarioDTO){
        return ResponseEntity.ok(usuarioService.alterarUsuario(requestUsuarioDTO));
    }

    @DeleteMapping(value = "/{id}")
    public void deletaUsuario(@PathVariable Long id){
        usuarioService.deletaUsuario(id);
    }
}
