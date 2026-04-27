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
public class Coordenador extends Pessoa {

    private String cargo;

    @OneToMany(mappedBy = "coordenador")
    @JsonIgnoreProperties("coordenador")
    @Builder.Default
    private List<SolicitacaoAPO> solicitacoes = new ArrayList<>();
}