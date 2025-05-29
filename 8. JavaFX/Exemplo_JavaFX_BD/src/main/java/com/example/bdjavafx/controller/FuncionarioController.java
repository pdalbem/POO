package com.example.bdjavafx.controller;

import com.example.bdjavafx.domain.exception.EntityAlreadyExistsException;
import com.example.bdjavafx.domain.model.Departamento;
import com.example.bdjavafx.domain.model.Funcionario;
import com.example.bdjavafx.domain.usecase.DepartamentoUseCase;
import com.example.bdjavafx.domain.usecase.FuncionarioUseCase;
import javafx.beans.property.ReadOnlyStringWrapper;
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
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class FuncionarioController implements Initializable {

    @FXML private TextField txtcpffunc;
    @FXML private TextField txtnomefunc;
    @FXML private ComboBox<Departamento> comboDepartamento;
    @FXML private Button btnSalvar, btnExcluir, btnCancelar;
    @FXML private TableView<Funcionario> tblFuncionario;
    @FXML private TableColumn<Funcionario, String> colCPFFunc, colNomeFunc, colDepFunc;

    private ObservableList<Funcionario> listView = FXCollections.observableArrayList();
    private ObservableList<Departamento> listViewDepartamento = FXCollections.observableArrayList();

    private FuncionarioUseCase funcionarioUseCase;
    private DepartamentoUseCase departamentoUseCase;

    private Funcionario funcionarioSelecionado = null;

    public void setFuncionarioUseCase(FuncionarioUseCase useCase) {
        this.funcionarioUseCase = useCase;
    }

    public void setDepartamentoUseCase(DepartamentoUseCase useCase) {
        this.departamentoUseCase = useCase;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarTabela();
    }

    public void carregarDados() {
        preencherTabela();
        preencherComboBox();
        limparCampos();
        habilitarCampos(true);
        habilitarBotoes(true, false, false);
    }

    private void configurarTabela() {
        colCPFFunc.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colNomeFunc.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colDepFunc.setCellValueFactory(data -> new ReadOnlyStringWrapper(
                data.getValue().getDepartamento() != null ? data.getValue().getDepartamento().getNome() : ""));
        tblFuncionario.setItems(listView);
    }

    private void preencherTabela() {
        listView.setAll(funcionarioUseCase.listarTodos());
    }

    private void preencherComboBox() {
        listViewDepartamento.setAll(departamentoUseCase.listarTodos());
        comboDepartamento.setItems(listViewDepartamento);
        comboDepartamento.setConverter(new StringConverter<>() {
            public String toString(Departamento d) { return d != null ? d.getNome() : ""; }
            public Departamento fromString(String s) { return null; }
        });
    }

    @FXML
    private void salvar(ActionEvent event) {
        if (!validarCampos()) return;

        String cpf = txtcpffunc.getText().trim();
        String nome = txtnomefunc.getText().trim();
        Departamento departamento = comboDepartamento.getValue();

        try {
            if (funcionarioSelecionado == null) {
                // Inserir novo
                Funcionario f = new Funcionario(cpf, nome, departamento);
                funcionarioUseCase.salvar(f);
            } else {
                // Atualizar existente
                funcionarioSelecionado.setCpf(cpf);
                funcionarioSelecionado.setNome(nome);
                funcionarioSelecionado.setDepartamento(departamento);
                funcionarioUseCase.atualizar(funcionarioSelecionado);
            }
        } catch (EntityAlreadyExistsException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de validação");
            alert.setHeaderText("Não foi possível salvar o funcionário. Já existe outro com este CPF.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            return;
        }

        atualizarTabelaELimpar();
    }

    @FXML
    private void excluir(ActionEvent event) {
        if (funcionarioSelecionado == null) {
            new Alert(Alert.AlertType.WARNING, "Selecione um funcionário para excluir.").showAndWait();
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                "Confirma exclusão do funcionário " + funcionarioSelecionado.getNome() + "?",
                ButtonType.YES, ButtonType.NO);
        confirm.setTitle("Confirmação");
        confirm.showAndWait();

        if (confirm.getResult() == ButtonType.YES) {
            funcionarioUseCase.excluir(funcionarioSelecionado);
            atualizarTabelaELimpar();
        }
    }

    @FXML
    private void selecionaFunc(MouseEvent event) {
        Funcionario f = tblFuncionario.getSelectionModel().getSelectedItem();
        if (f == null) return;

        funcionarioSelecionado = f;

        txtcpffunc.setText(f.getCpf());
        txtnomefunc.setText(f.getNome());
        comboDepartamento.setValue(f.getDepartamento());

        habilitarCampos(true);
        habilitarBotoes(true, true, true);
    }

    @FXML
    private void cancelar(ActionEvent event) {
        limparCampos();
    }

    private void limparCampos() {
        txtcpffunc.clear();
        txtnomefunc.clear();
        comboDepartamento.getSelectionModel().clearSelection();

        tblFuncionario.getSelectionModel().clearSelection();
        funcionarioSelecionado = null;

        habilitarCampos(true);
        habilitarBotoes(true, false, false);
    }

    private void habilitarCampos(boolean habilitar) {
        txtcpffunc.setEditable(habilitar);
        txtnomefunc.setEditable(habilitar);
        comboDepartamento.setDisable(!habilitar);
    }

    private void habilitarBotoes(boolean salvar, boolean excluir, boolean cancelar) {
        btnSalvar.setDisable(!salvar);
        btnExcluir.setDisable(!excluir);
        btnCancelar.setDisable(!cancelar);
    }

    private boolean validarCampos() {
        String cpf = txtcpffunc.getText().trim();
        String nome = txtnomefunc.getText().trim();
        Departamento departamento = comboDepartamento.getValue();

        if (cpf.isEmpty() || nome.isEmpty() || departamento == null) {
            new Alert(Alert.AlertType.WARNING, "Preencha todos os campos.").showAndWait();
            return false;
        }
        return true;
    }

    private void atualizarTabelaELimpar() {
        preencherTabela();
        limparCampos();
    }

    @FXML
    private void fecharJanela(ActionEvent event) {
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }
}
