package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entidades.Secretario;

public interface SecretarioRepository extends JpaRepository<Secretario, Long> {
}
