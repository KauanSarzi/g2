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
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssinatura;

    private LocalDate dataAssinatura;
    private String statusAssinatura;
    private String tipoSignatario;

    @ManyToOne
    @JoinColumn(name = "documento_id")
    @JsonIgnoreProperties("assinaturas") //para evitar loop quando virar api
    private Documento documento;
}