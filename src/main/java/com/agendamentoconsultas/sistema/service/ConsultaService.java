package com.agendamentoconsultas.sistema.service;

import com.agendamentoconsultas.sistema.model.Consulta;
import com.agendamentoconsultas.sistema.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private JavaMailSender mailSender;

    public Consulta agendarConsulta(Consulta consulta) {
        // Verifica conflito de horário
        if (consultaRepository.existsByProfissionalAndDataHora(consulta.getProfissional(), consulta.getDataHora())) {
            throw new RuntimeException("Horário indisponível para este profissional.");
        }

        // Salva a consulta
        Consulta consultaSalva = consultaRepository.save(consulta);

        // Envia email de confirmação
        enviarEmailConfirmacao(consultaSalva);

        return consultaSalva;
    }

    private void enviarEmailConfirmacao(Consulta consulta) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(consulta.getPacienteEmail());
        message.setSubject("Confirmação de Consulta");
        message.setText("Sua consulta com " + consulta.getProfissional().getNome() +
                " está agendada para " + consulta.getDataHora() + ".");
        mailSender.send(message);
    }
}