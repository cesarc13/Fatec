package com.gerenciarProdutos;

import com.gerenciarProdutos.model.ItemControleCaixa;
import com.gerenciarProdutos.model.Produto;
import com.gerenciarProdutos.telas.EntradaSaidaProdutos;
import com.gerenciarProdutos.telas.ListaProduto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    private static List<Produto> listaProdutos = new ArrayList<>();
    private static List<ItemControleCaixa> controleEstoque = new ArrayList<>();

    public static void main(String[] args) {
        Produto produto = new Produto(
                "CB01", "Passatempo chocolate", "Biscoito Passatempo chocolate 130g",
                "Passatempo", 1);
        ItemControleCaixa itemControleCaixa = new ItemControleCaixa(
                new Date(), produto, 1,2.10, "Entrada");
        listaProdutos.add(produto);
        controleEstoque.add(itemControleCaixa);
        new EntradaSaidaProdutos().setVisible(true);
    }

    public static List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public static void setListaProdutos(List<Produto> listaProdutos) {
        Main.listaProdutos = listaProdutos;
    }

    public static List<ItemControleCaixa> getControleEstoque() {
        return controleEstoque;
    }

    public static void setControleEstoque(List<ItemControleCaixa> controleEstoque) {
        Main.controleEstoque = controleEstoque;
    }
}
