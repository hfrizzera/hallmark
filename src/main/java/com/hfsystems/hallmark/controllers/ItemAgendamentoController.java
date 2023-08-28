package com.hfsystems.hallmark.controllers;

import com.hfsystems.hallmark.dto.AgendamentoDTO;
import com.hfsystems.hallmark.dto.ItemAgendamentoDTO;
import com.hfsystems.hallmark.dto.RequestAgendamentoDTO;
import com.hfsystems.hallmark.dto.RequestItemAgendamentoDTO;
import com.hfsystems.hallmark.entities.Agendamento;
import com.hfsystems.hallmark.entities.ItemAgendamento;
import com.hfsystems.hallmark.services.AgendamentoService;
import com.hfsystems.hallmark.services.ItemAgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/itemAgendamentos")
public class ItemAgendamentoController {

    @Autowired
    private ItemAgendamentoService itemAgendamentoService;

    @GetMapping(value = "/{id}")
    public ItemAgendamentoDTO findById(@PathVariable Long id){
        return itemAgendamentoService.findById(id);
    }

    @GetMapping
    public List<ItemAgendamentoDTO> findAll(){
        return itemAgendamentoService.findAll();
    }

    @PostMapping
    public ResponseEntity<ItemAgendamento> salvarItemAgendamento(@RequestBody @Valid RequestItemAgendamentoDTO requestItemAgendamentoDTO){
        return ResponseEntity.ok(itemAgendamentoService.salvarItemAgendamento(requestItemAgendamentoDTO));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ItemAgendamento> alterarItemAgendamento(@RequestBody @Valid RequestItemAgendamentoDTO requestItemAgendamentoDTO){
        return ResponseEntity.ok(itemAgendamentoService.alterarItemAgendamento(requestItemAgendamentoDTO));
    }

    @DeleteMapping(value = "/{id}")
    public void deletaItemAgendamento(@PathVariable Long id){
        itemAgendamentoService.deletaItemAgendamento(id);
    }
}
