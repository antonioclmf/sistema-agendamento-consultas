package com.agendamentoconsultas.sistema.repository;

import com.agendamentoconsultas.sistema.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}