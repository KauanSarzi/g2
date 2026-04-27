package com.example.demo.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entidades.SolicitacaoAPO;

public interface SolicitacaoAPORepository extends JpaRepository<SolicitacaoAPO, Long> {
    List<SolicitacaoAPO> findByAluno_IdPessoa(Long alunoId);
}
