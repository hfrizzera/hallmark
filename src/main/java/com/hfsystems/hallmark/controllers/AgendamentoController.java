package com.hfsystems.hallmark.controllers;

import com.hfsystems.hallmark.dto.AgendamentoDTO;
import com.hfsystems.hallmark.dto.RequestAgendamentoDTO;
import com.hfsystems.hallmark.dto.RequestUsuarioDTO;
import com.hfsystems.hallmark.dto.UsuarioDTO;
import com.hfsystems.hallmark.entities.Agendamento;
import com.hfsystems.hallmark.entities.Usuario;
import com.hfsystems.hallmark.services.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping(value = "/{id}")
    public AgendamentoDTO findById(@PathVariable Long id){
        return agendamentoService.findById(id);
    }

    @GetMapping
    public List<AgendamentoDTO> findAll(){
        return agendamentoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody @Valid RequestAgendamentoDTO requestAgendamentoDTO){
        return ResponseEntity.ok(agendamentoService.salvarAgendamento(requestAgendamentoDTO));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Agendamento> alterarAgendamento(@RequestBody @Valid RequestAgendamentoDTO requestAgendamentoDTO){
        return ResponseEntity.ok(agendamentoService.alterarAgendamento(requestAgendamentoDTO));
    }

    @DeleteMapping(value = "/{id}")
    public void deletaAgendamento(@PathVariable Long id){
        agendamentoService.deletaAgendamento(id);
    }
}
