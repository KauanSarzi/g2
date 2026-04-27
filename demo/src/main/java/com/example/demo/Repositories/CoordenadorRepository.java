package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entidades.Coordenador;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {
}
