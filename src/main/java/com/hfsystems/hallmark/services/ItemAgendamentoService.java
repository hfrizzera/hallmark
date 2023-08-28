package com.hfsystems.hallmark.services;

import com.hfsystems.hallmark.dto.AgendamentoDTO;
import com.hfsystems.hallmark.dto.ItemAgendamentoDTO;
import com.hfsystems.hallmark.dto.RequestAgendamentoDTO;
import com.hfsystems.hallmark.dto.RequestItemAgendamentoDTO;
import com.hfsystems.hallmark.entities.Agendamento;
import com.hfsystems.hallmark.entities.ItemAgendamento;
import com.hfsystems.hallmark.repositories.ItemAgendamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemAgendamentoService {

    private final ItemAgendamentoRepository itemAgendamentoRepository;

    public ItemAgendamentoService(ItemAgendamentoRepository itemAgendamentoRepository){
        this.itemAgendamentoRepository = itemAgendamentoRepository;
    }

    @Transactional(readOnly = true)
    public ItemAgendamentoDTO findById(Long id){
        return new ItemAgendamentoDTO(itemAgendamentoRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<ItemAgendamentoDTO> findAll(){
        return itemAgendamentoRepository.findAll().stream().map(x -> new ItemAgendamentoDTO(x)).toList();
    }

    public ItemAgendamento salvarItemAgendamento(RequestItemAgendamentoDTO requestItemAgendamentoDTO){
        ItemAgendamento itemAgendamento = new ItemAgendamento(requestItemAgendamentoDTO);
        return itemAgendamentoRepository.save(itemAgendamento);
    }

    public ItemAgendamento alterarItemAgendamento(RequestItemAgendamentoDTO requestItemAgendamentoDTO){
        Optional<ItemAgendamento> optionalItemAgendamento = itemAgendamentoRepository.findById(requestItemAgendamentoDTO.id());
        if(optionalItemAgendamento.isPresent()) {
            ItemAgendamento itemAgendamento = optionalItemAgendamento.get();
            itemAgendamento.setAgendamento(requestItemAgendamentoDTO.agendamento());
            itemAgendamento.setServico(requestItemAgendamentoDTO.servico());
            itemAgendamento.setHoraItem(requestItemAgendamentoDTO.horaItem());
            itemAgendamento.setValorItem(requestItemAgendamentoDTO.valorItem());
            return itemAgendamento;
        }else{
            throw new RuntimeException("Agendamento não encontrada!");
        }
    }

    public void deletaItemAgendamento(Long id){
        itemAgendamentoRepository.deleteById(id);
    }
}
