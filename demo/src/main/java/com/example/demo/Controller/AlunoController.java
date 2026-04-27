package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return solicitacaoRepository.findByAluno_IdPessoa(id);
    }

    @PostMapping("/{id}/submeter-apo")
    public SolicitacaoAPO submeterAPO(@PathVariable @NonNull Long id,
                                      @RequestBody @NonNull SubmeterAPORequest request) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        SolicitacaoAPO solicitacao = SolicitacaoAPO.builder()
                .aluno(aluno)
                .dataCriacao(LocalDate.now())
                .dataEnvio(LocalDate.now())
                .status("SUBMETIDA")
                .build();

        List<ItemAPO> itens = new ArrayList<>();
        if (request.getItens() != null) {
            for (SubmeterAPORequest.ItemRequest itemReq : request.getItens()) {
                ItemAPO item = ItemAPO.builder()
                        .descricao(itemReq.getDescricao())
                        .tipo(itemReq.getTipo())
                        .pontuacao(itemReq.getPontuacao())
                        .solicitacao(solicitacao)
                        .build();
                itens.add(item);
            }
        }
        solicitacao.setItens(itens);

        return solicitacaoRepository.save(solicitacao);
    }
}
