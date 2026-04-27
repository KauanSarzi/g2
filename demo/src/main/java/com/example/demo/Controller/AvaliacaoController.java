package com.example.demo.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidades.Avaliacao;
import com.example.demo.Repositories.AvaliacaoRepository;
import java.util.List;
import lombok.NonNull;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoRepository repository;

    public AvaliacaoController(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Avaliacao> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Avaliacao buscar(@PathVariable @NonNull Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    }

    @PostMapping
    public Avaliacao criar(@RequestBody @NonNull Avaliacao obj) {
        return repository.save(obj);
    }

    @PutMapping("/{id}")
    public Avaliacao atualizar(@PathVariable Long id, @RequestBody @NonNull Avaliacao obj) {
        obj.setIdAvaliacao(id);
        return repository.save(obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable @NonNull Long id) {
        repository.deleteById(id);
    }
}
