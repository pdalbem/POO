package com.example.bdjavafx.controller;

import com.example.bdjavafx.EmpresaApplication;
import com.example.bdjavafx.di.AppFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController {

    private double calcWidth() {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        return screenBounds.getWidth() * 0.8;
    }

    private double calcHeight() {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        return screenBounds.getHeight() * 0.8;
    }

    private void centralizar(Stage stage, double width, double height) {
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((screenBounds.getWidth() - width) / 2);
        stage.setY((screenBounds.getHeight() - height) / 2);
    }

    public void sair(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void showDep(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(EmpresaApplication.class.getResource("depto-view.fxml"));
            Parent root = loader.load();

            // Obtém o controller
            DepartamentoController controller = loader.getController();

            // Injeta o use case
            controller.setDepartamentoUseCase(AppFactory.criarDepartamentoUseCase());
            controller.carregarDados();

            double width = calcWidth();
            double height = calcHeight();
            Stage stage = new Stage();
            stage.setTitle("Departamento");

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.setMinWidth(width);
            stage.setMinHeight(height);

            centralizar(stage, width, height);

            stage.initModality(Modality.APPLICATION_MODAL); // Define a janela como modal

            // Adiciona um manipulador para o evento de fechamento da janela
            stage.setOnCloseRequest(event -> {
                // Garante que o stage seja explicitamente fechado e seus recursos liberados.
                // Isso é importante para que o showAndWait() retorne corretamente.
                stage.close();
            });

            stage.showAndWait(); // Exibe e espera até que a janela seja fechada

        } catch (IOException e) {
            e.printStackTrace();
            // Você pode adicionar um Alert aqui para o usuário, se desejar
            // Ex: new Alert(Alert.AlertType.ERROR, "Erro ao abrir a janela de Departamento.").showAndWait();
        }
    }

    public void showFunc(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(EmpresaApplication.class.getResource("func-view.fxml"));
            Parent root = loader.load();

            FuncionarioController controller = loader.getController();
            controller.setFuncionarioUseCase(AppFactory.criarFuncionarioUseCase());
            controller.setDepartamentoUseCase(AppFactory.criarDepartamentoUseCase());
            controller.carregarDados();

            double width = calcWidth();
            double height = calcHeight();
            Stage stage = new Stage();
            stage.setTitle("Funcionário");
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.setWidth(width);
            stage.setHeight(height);
            stage.setMinWidth(width);
            stage.setMinHeight(height);

            centralizar(stage, width, height);

            stage.initModality(Modality.APPLICATION_MODAL); // Define a janela como modal

            // Adiciona um manipulador para o evento de fechamento da janela
            stage.setOnCloseRequest(event -> {
                // Garante que o stage seja explicitamente fechado e seus recursos liberados.
                // Isso é importante para que o showAndWait() retorne corretamente.
                stage.close();
            });

            stage.showAndWait(); // Exibe e espera até que a janela seja fechada

        } catch (IOException e) {
            e.printStackTrace();
            // Você pode adicionar um Alert aqui para o usuário, se desejar
            // Ex: new Alert(Alert.AlertType.ERROR, "Erro ao abrir a janela de Funcionário.").showAndWait();
        }
    }
}
