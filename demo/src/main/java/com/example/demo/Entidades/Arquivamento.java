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
public class Arquivamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArquivamento;

    private LocalDate dataArquivamento;
    private String localArquivo;
    private String observacao;

    @OneToOne
    @JoinColumn(name = "solicitacao_id", unique = true)
    @JsonIgnoreProperties("arquivamento")
    private SolicitacaoAPO solicitacao;
}