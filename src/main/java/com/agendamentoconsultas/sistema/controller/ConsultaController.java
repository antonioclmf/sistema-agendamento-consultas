package com.agendamentoconsultas.sistema.controller;

import com.agendamentoconsultas.sistema.model.Consulta;
import com.agendamentoconsultas.sistema.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public Consulta agendarConsulta(@RequestBody Consulta consulta) {
        return consultaService.agendarConsulta(consulta);
    }
}