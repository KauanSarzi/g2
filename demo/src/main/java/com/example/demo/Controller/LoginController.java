package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidades.Aluno;
import com.example.demo.Repositories.AlunoRepository;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final AlunoRepository alunoRepository;

    public LoginController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (request.getEmail() == null || request.getEmail().isBlank()) {
            return ResponseEntity.badRequest().body("Email é obrigatório.");
        }

        String email = request.getEmail().trim().toLowerCase();
        if (!email.endsWith("@mackenzista.br") && !email.endsWith("@mackenzie.br")) {
            return ResponseEntity.badRequest().body("Use seu email Mackenzista (@mackenzista.br).");
        }

        return alunoRepository.findByEmail(email)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("Aluno não encontrado. Verifique seu email ou solicite cadastro."));
    }

    public static class LoginRequest {
        private String email;
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }
}
