package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entidades.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
