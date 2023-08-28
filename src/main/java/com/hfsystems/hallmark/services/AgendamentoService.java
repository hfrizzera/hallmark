package com.hfsystems.hallmark.services;

import com.hfsystems.hallmark.dto.AgendamentoDTO;
import com.hfsystems.hallmark.dto.RequestAgendamentoDTO;
import com.hfsystems.hallmark.dto.RequestUsuarioDTO;
import com.hfsystems.hallmark.dto.UsuarioDTO;
import com.hfsystems.hallmark.entities.Agendamento;
import com.hfsystems.hallmark.entities.Usuario;
import com.hfsystems.hallmark.repositories.AgendamentoRepository;
import com.hfsystems.hallmark.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }
    @Transactional(readOnly = true)
    public AgendamentoDTO findById(Long id){
        return new AgendamentoDTO(agendamentoRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<AgendamentoDTO> findAll(){
        return agendamentoRepository.findAll().stream().map(x -> new AgendamentoDTO(x)).toList();
    }

    public Agendamento salvarAgendamento(RequestAgendamentoDTO requestAgendamentoDTO){
        Agendamento agendamento = new Agendamento(requestAgendamentoDTO);
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento alterarAgendamento(RequestAgendamentoDTO requestAgendamentoDTO){
        Optional<Agendamento> optionalAgendamento = agendamentoRepository.findById(requestAgendamentoDTO.id());
        if(optionalAgendamento.isPresent()) {
            Agendamento agendamento = optionalAgendamento.get();
            agendamento.setPessoa(requestAgendamentoDTO.pessoa());
            agendamento.setUsuario(requestAgendamentoDTO.usuario());
            agendamento.setDataAgendamento(requestAgendamentoDTO.dataAgendamento());
            agendamento.setHoraInicio(requestAgendamentoDTO.horaInicio());
            agendamento.setHoraFinal(requestAgendamentoDTO.horaFinal());
            agendamento.setValorTotalServico(requestAgendamentoDTO.valorTotalServico());
            return agendamento;
        }else{
            throw new RuntimeException("Agendamento não encontrada!");
        }
    }

    public void deletaAgendamento(Long id){
        agendamentoRepository.deleteById(id);
    }
}
