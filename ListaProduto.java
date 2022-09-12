package com.gerenciarProdutos.telas;

import com.gerenciarProdutos.Main;
import com.gerenciarProdutos.model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListaProduto extends JFrame {
    private JPanel menuPanel;
    private JButton produtosButton;
    private JButton entradaESaídaProdutosButton;
    private JTable estoqueProdutosTabela;
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JTextField codigoTextField;
    private JTextField nomeTextField;
    private JTextField descricaoTextField;
    private JTextField marcaTextField;
    private JButton limparButton;
    private JButton salvarButton;

    public ListaProduto() {
        setSize(800, 600);
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        atualizarTabela();

        entradaESaídaProdutosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new EntradaSaidaProdutos().setVisible(true);
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
                codigoTextField.requestFocus();
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codigoTextField.getText().isEmpty() || nomeTextField.getText().isEmpty() ||
                        descricaoTextField.getText().isEmpty() || marcaTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame("Erro"), "Todos campos são obrigatórios");
                } else {
                    Produto novoProduto = new Produto(
                            codigoTextField.getText(), nomeTextField.getText(),
                            descricaoTextField.getText(), marcaTextField.getText(), 0
                    );
                    Main.getListaProdutos().add(novoProduto);
                    limparCampos();
                    atualizarTabela();
                    JOptionPane.showMessageDialog(new JFrame("Salvo"), "Produto salvo com sucesso!");
                    codigoTextField.requestFocus();

                }
            }
        });
    }

    private void atualizarTabela() {
        DefaultTableModel tabela = new DefaultTableModel();
        tabela.setColumnIdentifiers(new Object[]{"Código", "Nome", "Descrição", "Marca", "Estoque (und.)"});
        List<Produto> produtos = Main.getListaProdutos();
        for (int i = 0; i < produtos.size(); i++) {
            tabela.addRow(new Object[]{
                    produtos.get(i).getCodigo(), produtos.get(i).getNome(),
                    produtos.get(i).getDescricao(), produtos.get(i).getMarca(), produtos.get(i).getQuantidadeEstoque()});
        }
        estoqueProdutosTabela.setModel(tabela);
    }

    private void limparCampos() {
        codigoTextField.setText("");
        nomeTextField.setText("");
        descricaoTextField.setText("");
        marcaTextField.setText("");
    }
}
