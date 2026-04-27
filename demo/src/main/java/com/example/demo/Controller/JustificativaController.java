package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidades.Justificativa;
import com.example.demo.Repositories.JustificativaRepository;
import java.util.List;
import lombok.NonNull;

@RestController
@RequestMapping("/justificativas")
public class JustificativaController {

    private final JustificativaRepository repository;

    public JustificativaController(JustificativaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Justificativa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Justificativa criar(@RequestBody @NonNull Justificativa obj) {
        return repository.save(obj);
    }
}