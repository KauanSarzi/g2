package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Entidades.ItemAPO;
import com.example.demo.Repositories.ItemAPORepository;
import java.util.List;
import lombok.NonNull;

@RestController
@RequestMapping("/itens")
public class ItemAPOController {

    private final ItemAPORepository repository;

    public ItemAPOController(ItemAPORepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ItemAPO> listar() {
        return repository.findAll();
    }

    @PostMapping
    public ItemAPO criar(@RequestBody @NonNull ItemAPO obj) {
        return repository.save(obj);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable @NonNull Long id) {
        repository.deleteById(id);
    }
}
