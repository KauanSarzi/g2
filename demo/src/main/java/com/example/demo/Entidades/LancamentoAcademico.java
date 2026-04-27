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
public class LancamentoAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLancamento;

    private LocalDate dataLancamento;
    private Double pontuacaoLancada;
    private String statusLancamento;

    @OneToOne
    @JoinColumn(name = "solicitacao_id", unique = true)
    @JsonIgnoreProperties("lancamentoAcademico") //PARA EVITAR LOOP QUANDO VIRAR API
    private SolicitacaoAPO solicitacao;
}