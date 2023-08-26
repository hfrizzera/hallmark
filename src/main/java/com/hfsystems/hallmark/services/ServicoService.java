package com.hfsystems.hallmark.services;

import com.hfsystems.hallmark.dto.RequestServicoDTO;
import com.hfsystems.hallmark.dto.ServicoDTO;
import com.hfsystems.hallmark.entities.Servico;
import com.hfsystems.hallmark.repositories.ServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository){
        this.servicoRepository = servicoRepository;
    }

    @Transactional(readOnly = true)
    public ServicoDTO findById(Long id){
        return new ServicoDTO(servicoRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<ServicoDTO> findAll(){
        return servicoRepository.findAll().stream().map(x -> new ServicoDTO(x)).toList();
    }

    public Servico salvarServico(RequestServicoDTO requestServicoDTO){
        Servico servico = new Servico(requestServicoDTO);
        return servicoRepository.save(servico);
    }

    public Servico alterarServico(RequestServicoDTO requestServicoDTO){
        Optional<Servico> optionalServico = servicoRepository.findById(requestServicoDTO.id());
        if(optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            servico.setDescricao(requestServicoDTO.descricao());
            servico.setValor(requestServicoDTO.valor());
            servico.setHoraServico(requestServicoDTO.horaServico());
            return servico;
        }else{
            throw new RuntimeException("Serviço não encontrada!");
        }
    }

    public void deletaServico(Long id){
        servicoRepository.deleteById(id);
    }
}
