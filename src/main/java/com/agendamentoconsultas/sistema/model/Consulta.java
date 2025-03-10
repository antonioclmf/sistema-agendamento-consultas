package com.agendamentoconsultas.sistema.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pacienteNome;
    private String pacienteEmail;
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;
}