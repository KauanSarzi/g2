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
public class Aluno extends Pessoa {

    private String matricula;
    private String curso;

    @OneToMany(mappedBy = "aluno")
    @JsonIgnoreProperties("aluno") //para evitar loop quando virar api
    @Builder.Default
    private List<SolicitacaoAPO> solicitacoes = new ArrayList<>();
}