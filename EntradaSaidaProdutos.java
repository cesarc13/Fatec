package com.gerenciarProdutos.telas;

import com.gerenciarProdutos.Main;
import com.gerenciarProdutos.model.ItemControleCaixa;
import com.gerenciarProdutos.model.Produto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EntradaSaidaProdutos extends JFrame {
    private JPanel menuPanel;
    private JButton produtosButton;
    private JButton entradaESaídaProdutosButton;
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JTable entradaSaidaTabela;
    private JTextField dataTextField;
    private JComboBox produtoComboBox;
    private JTextField quantidadeTextField;
    private JTextField precoTextField;
    private JComboBox entradaSaidaComboBox;
    private JButton limparButton;
    private JButton cadastrarButton;


    public EntradaSaidaProdutos() {
        setSize(800, 600);
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        atualizarTabela();
        atualizarProdutos();
        limparCampos();

        produtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ListaProduto().setVisible(true);
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (precoTextField.getText().isEmpty() || dataTextField.getText().isEmpty() ||
                        quantidadeTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame("Erro"), "Todos campos são obrigatórios");
                } else {
                    try {
                        Produto produtoSelecionado = Main.getListaProdutos().get(produtoComboBox.getSelectedIndex());
                        ItemControleCaixa novoItem = new ItemControleCaixa(
                                formatarStringParaData(dataTextField.getText()),
                                produtoSelecionado,
                                Integer.parseInt(quantidadeTextField.getText()),
                                Double.parseDouble(precoTextField.getText()),
                                entradaSaidaComboBox.getSelectedItem().toString()
                        );
                        Integer qtdEstoque = produtoSelecionado.getQuantidadeEstoque();
                        if (entradaSaidaComboBox.getSelectedIndex() == 1) {
                            qtdEstoque -= Integer.parseInt(quantidadeTextField.getText());

                            if (qtdEstoque < 0) {
                                JOptionPane.showMessageDialog(new JFrame("Erro"), "Quantidade indisponível em estoque");
                                return;
                            }
                        } else {
                            qtdEstoque += Integer.parseInt(quantidadeTextField.getText());
                        }
                        Main.getControleEstoque().add(novoItem);
                        Main.getListaProdutos().get(produtoComboBox.getSelectedIndex()).setQuantidadeEstoque(qtdEstoque);
                        limparCampos();
                        atualizarTabela();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(new JFrame("Erro"), "É esperado um número");
                    }

                }
            }
        });
    }

    private void limparCampos() {
        dataTextField.setText(formatarDataParaString(new Date()));
        precoTextField.setText("");
        quantidadeTextField.setText("");
        produtoComboBox.setSelectedIndex(0);
        entradaSaidaComboBox.setSelectedIndex(0);
    }

    private void atualizarTabela() {
        DefaultTableModel tabela = new DefaultTableModel();
        tabela.setColumnIdentifiers(new Object[]{"Tipo", "Data", "Produto", "Preço und.", "Quantidade"});
        List<ItemControleCaixa> controleEstoque = Main.getControleEstoque();
        for (int i = 0; i < controleEstoque.size(); i++) {
            tabela.addRow(new Object[]{
                    controleEstoque.get(i).getEntradaOuSaida(), formatarDataParaString(controleEstoque.get(i).getData()),
                    controleEstoque.get(i).getProduto().getNome(), controleEstoque.get(i).getPrecoUnitario(),
                    controleEstoque.get(i).getQuantidade()});
        }
        entradaSaidaTabela.setModel(tabela);
    }

    private void atualizarProdutos() {
        List<Produto> listaProdutos = Main.getListaProdutos();
        for (int i = 0; i < listaProdutos.size(); i++) {
            produtoComboBox.addItem(listaProdutos.get(i).getNome());
        }
    }

    private String formatarDataParaString(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String str = fmt.format(date);
        return str;
    }

    private Date formatarStringParaData(String dateStr) {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = fmt.parse(dateStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(new JFrame("Erro"), "Data inválida");
        }
        return data;
    }
}
