package com.example.demo.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidades.Documento;
import com.example.demo.Repositories.DocumentoRepository;
import lombok.NonNull;
import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    private final DocumentoRepository repository;

    public DocumentoController(DocumentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Documento> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Documento buscar(@PathVariable @NonNull Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));
    }

    @PostMapping
    public Documento criar(@RequestBody @NonNull Documento obj) {
        return repository.save(obj);
    }

    @PutMapping("/{id}")
    public Documento atualizar(@PathVariable Long id, @RequestBody Documento obj) {
        obj.setIdDocumento(id);
        return repository.save(obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable @NonNull Long id) {
        repository.deleteById(id);
    }
}
