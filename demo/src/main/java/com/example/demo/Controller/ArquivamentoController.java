package com.example.demo.Controller;

import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.Entidades.Arquivamento;
import com.example.demo.Repositories.ArquivamentoRepository;

@RestController
@RequestMapping("/arquivamentos")
public class ArquivamentoController {

    private final ArquivamentoRepository repository;

    public ArquivamentoController(ArquivamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Arquivamento> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Arquivamento criar(@RequestBody @NonNull Arquivamento obj) {
        return repository.save(obj);
    }
}
