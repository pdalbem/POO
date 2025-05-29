module org.example.exemplo_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports org.example.exemplo_javafx.app;

    opens org.example.exemplo_javafx.app.controller to javafx.fxml;

}