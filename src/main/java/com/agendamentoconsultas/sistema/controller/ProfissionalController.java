package com.agendamentoconsultas.sistema.controller;

import com.agendamentoconsultas.sistema.service.ProfissionalService;
import com.agendamentoconsultas.sistema.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @GetMapping
    public List<Profissional> listarTodos() {
        return profissionalService.listarTodos();
    }

    @PostMapping
    public Profissional salvar(@RequestBody Profissional profissional) {
        return profissionalService.salvar(profissional);
    }
}