package com.hfsystems.hallmark.controllers;

import com.hfsystems.hallmark.dto.PessoaDTO;
import com.hfsystems.hallmark.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping(value = "/{id}")
    public PessoaDTO pesquisarPorId(@PathVariable Long id){
        return pessoaService.pesquisarPorId(id);
    }
}
