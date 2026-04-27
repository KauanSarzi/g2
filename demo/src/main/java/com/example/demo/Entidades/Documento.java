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
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;

    private String tipoDocumento;
    private LocalDate dataGeracao;
    private String statusDocumento;

    @ManyToOne
    @JoinColumn(name = "solicitacao_id")
    @JsonIgnoreProperties("documentos")
    private SolicitacaoAPO solicitacao;

    @ManyToOne
    @JoinColumn(name = "secretario_id")
    @JsonIgnoreProperties("documentos")
    private Secretario secretario;

    @OneToMany(mappedBy = "documento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("documento")
    @Builder.Default
    private List<Assinatura> assinaturas = new ArrayList<>();
}