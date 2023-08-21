package com.hfsystems.hallmark.repositories;

import com.hfsystems.hallmark.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
