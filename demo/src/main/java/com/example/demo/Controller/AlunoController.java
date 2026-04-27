package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.NonNull;
import com.example.demo.Entidades.Aluno;
import com.example.demo.Entidades.ItemAPO;
import com.example.demo.Entidades.SolicitacaoAPO;
import com.example.demo.Repositories.AlunoRepository;
import com.example.demo.Repositories.SolicitacaoAPORepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository repository;
    private final SolicitacaoAPORepository solicitacaoRepository;

    public AlunoController(AlunoRepository repository, SolicitacaoAPORepository solicitacaoRepository) {
        this.repository = repository;
        this.solicitacaoRepository = solicitacaoRepository;
    }

    @GetMapping
    public List<Aluno> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable @NonNull Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @PostMapping
    public Aluno criar(@RequestBody @NonNull Aluno aluno) {
        return repository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        aluno.setIdPessoa(id);
        return repository.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable @NonNull Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/{id}/solicitacoes")
    public List<SolicitacaoAPO> listarSolicitacoes(@PathVariable @NonNull Long id) {
        return solicitacaoRepository.findByAluno_IdPessoa(id);
    }

    @PostMapping("/{id}/submeter-apo")
    public ResponseEntity<?> submeterAPO(@PathVariable @NonNull Long id,
                                          @RequestBody SubmissaoAPORequest request) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        SolicitacaoAPO solicitacao = SolicitacaoAPO.builder()
                .dataCriacao(LocalDate.now())
                .dataEnvio(LocalDate.now())
                .status("ENVIADA")
                .aluno(aluno)
                .build();

        if (request.getItens() != null) {
            for (SubmissaoAPORequest.ItemRequest itemReq : request.getItens()) {
                ItemAPO item = new ItemAPO();
                item.setDescricao(itemReq.getDescricao());
                item.setTipo(itemReq.getTipo());
                item.setPontuacao(itemReq.getPontuacao());
                item.setSolicitacao(solicitacao);
                solicitacao.getItens().add(item);
            }
        }

        return ResponseEntity.ok(solicitacaoRepository.save(solicitacao));
    }

    public static class SubmissaoAPORequest {
        private List<ItemRequest> itens;
        public List<ItemRequest> getItens() { return itens; }
        public void setItens(List<ItemRequest> itens) { this.itens = itens; }

        public static class ItemRequest {
            private String descricao;
            private String tipo;
            private Double pontuacao;

            public String getDescricao() { return descricao; }
            public void setDescricao(String descricao) { this.descricao = descricao; }
            public String getTipo() { return tipo; }
            public void setTipo(String tipo) { this.tipo = tipo; }
            public Double getPontuacao() { return pontuacao; }
            public void setPontuacao(Double pontuacao) { this.pontuacao = pontuacao; }
        }
    }
}
