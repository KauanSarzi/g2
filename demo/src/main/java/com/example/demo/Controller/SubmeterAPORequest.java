package com.example.demo.Controller;

import java.util.List;

public class SubmeterAPORequest {

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
