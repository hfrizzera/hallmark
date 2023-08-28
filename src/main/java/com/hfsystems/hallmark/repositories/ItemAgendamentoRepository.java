package com.hfsystems.hallmark.repositories;

import com.hfsystems.hallmark.entities.ItemAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemAgendamentoRepository extends JpaRepository<ItemAgendamento, Long> {
}
