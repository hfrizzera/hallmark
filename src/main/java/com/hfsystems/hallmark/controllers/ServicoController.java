package com.hfsystems.hallmark.controllers;

import com.hfsystems.hallmark.dto.RequestServicoDTO;
import com.hfsystems.hallmark.dto.RequestUsuarioDTO;
import com.hfsystems.hallmark.dto.ServicoDTO;
import com.hfsystems.hallmark.dto.UsuarioDTO;
import com.hfsystems.hallmark.entities.Servico;
import com.hfsystems.hallmark.entities.Usuario;
import com.hfsystems.hallmark.services.ServicoService;
import com.hfsystems.hallmark.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping(value = "/{id}")
    public ServicoDTO findById(@PathVariable Long id){
        return servicoService.findById(id);
    }

    @GetMapping
    public List<ServicoDTO> findAll(){
        return servicoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Servico> salvarServico(@RequestBody @Valid RequestServicoDTO requestServicoDTO){
        return ResponseEntity.ok(servicoService.salvarServico(requestServicoDTO));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Servico> alterarServico(@RequestBody @Valid RequestServicoDTO requestServicoDTO){
        return ResponseEntity.ok(servicoService.alterarServico(requestServicoDTO));
    }

    @DeleteMapping(value = "/{id}")
    public void deletaServico(@PathVariable Long id){
        servicoService.deletaServico(id);
    }
}
