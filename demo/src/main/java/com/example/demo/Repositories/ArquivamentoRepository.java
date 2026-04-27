package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entidades.Arquivamento;

public interface ArquivamentoRepository extends JpaRepository<Arquivamento, Long> {
}
