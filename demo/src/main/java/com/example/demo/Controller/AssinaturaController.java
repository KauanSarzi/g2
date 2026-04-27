package com.example.demo.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidades.Assinatura;
import com.example.demo.Repositories.AssinaturaRepository;
import java.util.List;
import lombok.NonNull;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {

    private final AssinaturaRepository repository;

    public AssinaturaController(AssinaturaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Assinatura> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Assinatura criar(@RequestBody @NonNull Assinatura obj) {
        return repository.save(obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable @NonNull Long id) {
        repository.deleteById(id);
    }
}
