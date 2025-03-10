package com.agendamentoconsultas.sistema.repository;

import com.agendamentoconsultas.sistema.model.Consulta;
import com.agendamentoconsultas.sistema.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByProfissionalAndDataHora(Profissional profissional, LocalDateTime dataHora);
}