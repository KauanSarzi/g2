package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entidades.MembroComissao;

public interface MembroComissaoRepository extends JpaRepository<MembroComissao, Long> {
}
