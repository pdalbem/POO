package com.example.bdjavafx.controller;

import com.example.bdjavafx.domain.exception.EntityAlreadyExistsException;
import com.example.bdjavafx.domain.model.Departamento;
import com.example.bdjavafx.domain.usecase.DepartamentoUseCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartamentoController implements Initializable {

    @FXML private TextField txtnomedepto;
    @FXML private TextField txtsigladepto;
    @FXML private Button btnSalvar, btnExcluir, btnCancelar;
    @FXML private TableView<Departamento> tblDepartamento;
    @FXML private TableColumn<Departamento, String> colNomeDepto, colSiglaDepto;

    private ObservableList<Departamento> departamentos = FXCollections.observableArrayList();
    private DepartamentoUseCase departamentoUseCase;

    private Departamento departamentoSelecionado = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNomeDepto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colSiglaDepto.setCellValueFactory(new PropertyValueFactory<>("sigla"));
        tblDepartamento.setItems(departamentos);

        limparCampos();
    }

    public void setDepartamentoUseCase(DepartamentoUseCase useCase) {
        this.departamentoUseCase = useCase;
        carregarDados();
    }

    public void carregarDados() {
        departamentos.setAll(departamentoUseCase.listarTodos());
    }

    @FXML
    private void salvar(ActionEvent event) {
        if (!validarCampos()) return;

        String nome = txtnomedepto.getText().trim();
        String sigla = txtsigladepto.getText().trim();

        try {
            if (departamentoSelecionado == null) {
                Departamento d = new Departamento(nome, sigla);
                departamentoUseCase.salvar(d);
            } else {
                departamentoSelecionado.setNome(nome);
                departamentoSelecionado.setSigla(sigla);
                departamentoUseCase.atualizar(departamentoSelecionado);
            }
        } catch (EntityAlreadyExistsException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de validação");
            alert.setHeaderText("Já existe departamento com essa sigla.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }

        atualizarTabelaELimpar();
    }

    @FXML
    private void excluir(ActionEvent event) {
        if (departamentoSelecionado == null) {
            new Alert(Alert.AlertType.WARNING, "Selecione um departamento para excluir.").showAndWait();
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                "Confirma exclusão do departamento " + departamentoSelecionado.getNome() + "?",
                ButtonType.YES, ButtonType.NO);
        confirm.setTitle("Confirmação");
        confirm.showAndWait();

        if (confirm.getResult() == ButtonType.YES) {
            departamentoUseCase.excluir(departamentoSelecionado);
            atualizarTabelaELimpar();
        }
    }

    @FXML
    private void selecionaDepto(MouseEvent event) {
        Departamento d = tblDepartamento.getSelectionModel().getSelectedItem();
        if (d == null) return;

        departamentoSelecionado = d;
        txtnomedepto.setText(d.getNome());
        txtsigladepto.setText(d.getSigla());

        habilitarCampos(true);
        habilitarBotoes(true, true, true);
    }

    @FXML
    private void cancelar(ActionEvent event) {
        limparCampos();
    }

    private void limparCampos() {
        txtnomedepto.clear();
        txtsigladepto.clear();
        tblDepartamento.getSelectionModel().clearSelection();
        departamentoSelecionado = null;

        habilitarCampos(true);
        habilitarBotoes(true, false, false);
    }

    private void habilitarCampos(boolean habilitar) {
        txtnomedepto.setEditable(habilitar);
        txtsigladepto.setEditable(habilitar);
    }

    private void habilitarBotoes(boolean salvar, boolean excluir, boolean cancelar) {
        btnSalvar.setDisable(!salvar);
        btnExcluir.setDisable(!excluir);
        btnCancelar.setDisable(!cancelar);
    }

    private boolean validarCampos() {
        String nome = txtnomedepto.getText().trim();
        String sigla = txtsigladepto.getText().trim();

        if (nome.isEmpty() || sigla.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Preencha todos os campos.").showAndWait();
            return false;
        }
        return true;
    }

    private void atualizarTabelaELimpar() {
        carregarDados();
        limparCampos();
    }

    @FXML
    private void fecharJanela(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        
    }
}
