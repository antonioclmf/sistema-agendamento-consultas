package com.agendamentoconsultas.sistema.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Desabilita CSRF (útil para APIs RESTful)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/profissionais", "/consultas").authenticated() // Protege esses endpoints
                        .anyRequest().permitAll() // Permite acesso a todos os outros endpoints
                )
                .httpBasic(); // Usa autenticação básica (usuário e senha)

        return http.build();
    }
}