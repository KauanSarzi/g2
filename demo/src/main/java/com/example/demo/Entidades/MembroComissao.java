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
public class MembroComissao extends Pessoa {

    private String funcaoComissao;

    @OneToMany(mappedBy = "membroComissao")
    @JsonIgnoreProperties("membroComissao")
    @Builder.Default
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}