package com.gerenciarProdutos.model;

public class Produto {
    private String codigo;
    private String nome;
    private String descricao;
    private String marca;
    private Integer quantidadeEstoque;

    public Produto(String codigo, String nome, String descricao, String marca, Integer quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public Produto setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Produto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public Produto setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Produto setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
        return this;
    }
}
