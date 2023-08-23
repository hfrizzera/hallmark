package com.hfsystems.hallmark.services;

import com.hfsystems.hallmark.dto.PessoaDTO;
import com.hfsystems.hallmark.dto.RequestPessoaDTO;
import com.hfsystems.hallmark.entities.Pessoa;
import com.hfsystems.hallmark.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id){
        return new PessoaDTO(pessoaRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<PessoaDTO> findAll(){
        return pessoaRepository.findAll().stream().map(x -> new PessoaDTO(x)).toList();
    }

    public Pessoa salvarPessoa(RequestPessoaDTO requestPessoaDTO){
        Pessoa pessoa = new Pessoa(requestPessoaDTO);
        return pessoaRepository.save(pessoa);
    }

    public Pessoa alterarPessoa(RequestPessoaDTO requestPessoaDTO){
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(requestPessoaDTO.id());
        if(optionalPessoa.isPresent()) {
            Pessoa pessoa = optionalPessoa.get();
            pessoa.setNome(requestPessoaDTO.nome());
            pessoa.setTelefone(requestPessoaDTO.telefone());
            return pessoa;
        }else{
            throw new RuntimeException("Pessoa não encontrada!");
        }
    }

    public void deletaPessoa(Long id){
        pessoaRepository.deleteById(id);
    }
}
