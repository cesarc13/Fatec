package com.gerenciarProdutos.model;

import java.util.Date;

public class ItemControleCaixa {
    Date data;
    Produto produto;
    Integer quantidade;
    Double precoUnitario;
    String entradaOuSaida;

    public ItemControleCaixa(Date data, Produto produto, Integer quantidade, Double precoUnitario, String entradaOuSaida) {
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.entradaOuSaida = entradaOuSaida;
    }

    public Date getData() {
        return data;
    }

    public ItemControleCaixa setData(Date data) {
        this.data = data;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ItemControleCaixa setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ItemControleCaixa setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ItemControleCaixa setEntradaOuSaida(String entradaOuSaida) {
        this.entradaOuSaida = entradaOuSaida;
        return this;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public ItemControleCaixa setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
        return this;
    }

    public String getEntradaOuSaida() {
        return entradaOuSaida;
    }
}
