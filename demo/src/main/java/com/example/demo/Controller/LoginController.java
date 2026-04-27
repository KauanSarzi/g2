package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Repositories.AlunoRepository;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final AlunoRepository alunoRepository;

    public LoginController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email");

        if (email == null || email.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("erro", "Email é obrigatório"));
        }

        String emailLower = email.trim().toLowerCase();
        if (!emailLower.endsWith("@mackenzista.com.br") && !emailLower.endsWith("@mackenzie.br")) {
            return ResponseEntity.status(401)
                    .body(Map.of("erro", "Utilize seu email mackenzista para acessar o sistema"));
        }

        return alunoRepository.findByEmail(email.trim())
                .map(aluno -> ResponseEntity.ok((Object) aluno))
                .orElse(ResponseEntity.status(404)
                        .body(Map.of("erro", "Aluno não encontrado. Verifique seu email ou solicite o cadastro.")));
    }
}
