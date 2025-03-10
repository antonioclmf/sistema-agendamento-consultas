package com.agendamentoconsultas.sistema.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especialidade;
}