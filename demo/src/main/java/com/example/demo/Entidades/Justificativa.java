package com.example.demo.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Justificativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJustificativa;

    @Column(columnDefinition = "TEXT")
    private String texto;

    private LocalDate dataRegistro;

    @OneToOne
    @JoinColumn(name = "avaliacao_id", unique = true)
    @JsonIgnoreProperties("justificativa")
    private Avaliacao avaliacao;
}