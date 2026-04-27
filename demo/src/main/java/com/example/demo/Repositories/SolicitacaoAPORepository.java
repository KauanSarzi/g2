package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entidades.SolicitacaoAPO;
import java.util.List;

public interface SolicitacaoAPORepository extends JpaRepository<SolicitacaoAPO, Long> {
    List<SolicitacaoAPO> findByAluno_IdPessoa(Long alunoId);
}
