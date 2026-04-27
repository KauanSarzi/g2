package com.example.demo.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemAPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;

    private String descricao;
    private String tipo;
    private Double pontuacao;

    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    @JsonIgnoreProperties("itens")
    private SolicitacaoAPO solicitacao;
}