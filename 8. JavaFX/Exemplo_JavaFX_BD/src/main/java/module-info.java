module com.example.bdjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.bdjavafx to javafx.fxml;
    exports com.example.bdjavafx.domain.model;
    opens com.example.bdjavafx.domain.model to javafx.fxml;
    exports com.example.bdjavafx.infra;
    opens com.example.bdjavafx.infra to javafx.fxml;
     exports com.example.bdjavafx;
    exports com.example.bdjavafx.controller;
    opens com.example.bdjavafx.controller to javafx.fxml;
    exports com.example.bdjavafx.domain.repository;
    opens com.example.bdjavafx.domain.repository to javafx.fxml;

}