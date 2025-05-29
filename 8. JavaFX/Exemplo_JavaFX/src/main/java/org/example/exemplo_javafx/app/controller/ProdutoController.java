package org.example.exemplo_javafx.app.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.exemplo_javafx.application.ProdutoService;
import org.example.exemplo_javafx.domain.model.Produto;

public class ProdutoController {
    @FXML private TextField inputNome;
    @FXML private TextField inputPreco;
    @FXML private ListView<Produto> listaProdutos;
    @FXML private Button btnSalvar;
    @FXML private Button btnExcluir;

    private final ProdutoService service = new ProdutoService();
    private Produto selecionado = null;

    @FXML
    private void initialize() {
        atualizarLista();
        listaProdutos.setOnMouseClicked(this::selecionarItem);
    }

    private void selecionarItem(MouseEvent event) {
        selecionado = listaProdutos.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            inputNome.setText(selecionado.getNome());
            inputPreco.setText(String.valueOf(selecionado.getPreco()));
        }
    }

    @FXML
    private void salvar() {
        String nome = inputNome.getText();
        double preco = Double.parseDouble(inputPreco.getText());

        if (selecionado == null) {
            service.salvar(new Produto(nome, preco));
        } else {
            selecionado.setNome(nome);
            selecionado.setPreco(preco);
            service.atualizar(selecionado);
            selecionado = null;
        }
        limparCampos();
        atualizarLista();
    }

    @FXML
    private void excluir() {
        if (selecionado != null) {
            service.remover(selecionado.getId());
            limparCampos();
            atualizarLista();
        }
    }

    private void limparCampos() {
        inputNome.clear();
        inputPreco.clear();
        selecionado = null;
    }

    private void atualizarLista() {
        listaProdutos.getItems().setAll(service.listarTodos());
    }
}