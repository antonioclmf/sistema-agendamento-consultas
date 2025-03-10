package com.agendamentoconsultas.sistema.service;

import com.agendamentoconsultas.sistema.model.Profissional;
import com.agendamentoconsultas.sistema.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public List<Profissional> listarTodos() {
        return profissionalRepository.findAll();
    }

    public Profissional salvar(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }
}