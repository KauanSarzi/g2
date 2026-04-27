package com.example.demo.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitacaoAPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitacao;

    private LocalDate dataCriacao;
    private LocalDate dataEnvio;
    private String status;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    @JsonIgnoreProperties("solicitacoes")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "orientador_id")
    @JsonIgnoreProperties("solicitacoes")
    private Orientador orientador;

    @ManyToOne
    @JoinColumn(name = "coordenador_id")
    @JsonIgnoreProperties("solicitacoes")
    private Coordenador coordenador;

    @ManyToOne
    @JoinColumn(name = "secretario_id")
    @JsonIgnoreProperties("solicitacoes")
    private Secretario secretario;

    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("solicitacao")
    @Builder.Default
    private List<ItemAPO> itens = new ArrayList<>();

    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("solicitacao")
    @Builder.Default
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    @OneToMany(mappedBy = "solicitacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("solicitacao")
    @Builder.Default
    private List<Documento> documentos = new ArrayList<>();

    @OneToOne(mappedBy = "solicitacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("solicitacao")
    private Arquivamento arquivamento;

    @OneToOne(mappedBy = "solicitacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("solicitacao")
    private LancamentoAcademico lancamentoAcademico;
}