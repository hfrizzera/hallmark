package com.hfsystems.hallmark.controllers;

import com.hfsystems.hallmark.dto.PessoaDTO;
import com.hfsystems.hallmark.dto.RequestPessoaDTO;
import com.hfsystems.hallmark.entities.Pessoa;
import com.hfsystems.hallmark.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/{id}")
    public PessoaDTO findById(@PathVariable Long id){
        return pessoaService.findById(id);
    }

    @GetMapping
    public List<PessoaDTO> findAll(){
        return pessoaService.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvarPessoa(@RequestBody @Valid RequestPessoaDTO requestPessoaDTO){
        return ResponseEntity.ok(pessoaService.salvarPessoa(requestPessoaDTO));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Pessoa> alterarPessoa(@RequestBody @Valid RequestPessoaDTO requestPessoaDTO){
        return ResponseEntity.ok(pessoaService.alterarPessoa(requestPessoaDTO));
    }

    @DeleteMapping(value = "/{id}")
    public void deletaPessoa(@PathVariable Long id){
        pessoaService.deletaPessoa(id);
    }
}
