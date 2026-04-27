package com.example.demo.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entidades.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByEmail(String email);
}
