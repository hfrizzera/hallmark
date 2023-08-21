package com.hfsystems.hallmark.services;

import com.hfsystems.hallmark.dto.PessoaDTO;
import com.hfsystems.hallmark.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO pesquisarPorId(Long id){
        return new PessoaDTO(pessoaRepository.findById(id).get());
    }
}
