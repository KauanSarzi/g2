package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidades.SolicitacaoAPO;
import com.example.demo.Repositories.SolicitacaoAPORepository;
import java.util.List;
import lombok.NonNull;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoAPOController {

    private final SolicitacaoAPORepository repository;

    public SolicitacaoAPOController(SolicitacaoAPORepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SolicitacaoAPO> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public SolicitacaoAPO buscar(@PathVariable @NonNull Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada"));
    }

    @PostMapping
    public SolicitacaoAPO criar(@RequestBody @NonNull SolicitacaoAPO obj) {
        return repository.save(obj);
    }

    @PutMapping("/{id}")
    public SolicitacaoAPO atualizar(@PathVariable Long id, @RequestBody SolicitacaoAPO obj) {
        obj.setIdSolicitacao(id);
        return repository.save(obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable @NonNull Long id) {
        repository.deleteById(id);
    }
}
