package com.example.demo.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Secretario extends Pessoa {

    private String setor;

    @OneToMany(mappedBy = "secretario")
    @JsonIgnoreProperties("secretario")
    @Builder.Default
    private List<SolicitacaoAPO> solicitacoes = new ArrayList<>();

    @OneToMany(mappedBy = "secretario")
    @JsonIgnoreProperties("secretario")
    @Builder.Default
    private List<Documento> documentos = new ArrayList<>();
}