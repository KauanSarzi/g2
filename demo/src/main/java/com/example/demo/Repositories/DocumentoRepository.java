package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entidades.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
