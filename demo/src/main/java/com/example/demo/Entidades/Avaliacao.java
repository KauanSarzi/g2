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
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    private LocalDate dataAvaliacao;
    private String parecer;
    private String decisao;

    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    @JsonIgnoreProperties("avaliacoes")
    private SolicitacaoAPO solicitacao;

    @ManyToOne
    @JoinColumn(name = "membro_comissao_id")
    @JsonIgnoreProperties("avaliacoes")
    private MembroComissao membroComissao;

    @OneToOne(mappedBy = "avaliacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("avaliacao")
    private Justificativa justificativa;
}