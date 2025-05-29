package com.example.bdjavafx;

import com.example.bdjavafx.infra.DatabaseInitializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class EmpresaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        DatabaseInitializer.initialize();
        FXMLLoader fxmlLoader = new FXMLLoader(EmpresaApplication.class.getResource("principal-view.fxml"));
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        double width = screenBounds.getWidth() * 0.8;
        double height = screenBounds.getHeight() * 0.8;

        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle("JavaFX acessando BD");
        stage.setScene(scene);

        // Centralizar janela principal
        stage.setX((screenBounds.getWidth() - width) / 2);
        stage.setY((screenBounds.getHeight() - height) / 2);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
