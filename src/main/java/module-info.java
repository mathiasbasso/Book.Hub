module br.com.senac.bookhub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens br.com.senac.bookhub.model to javafx.fxml;
    exports br.com.senac.bookhub.model;

    opens br.com.senac.bookhub.repository to javafx.fxml;
    exports br.com.senac.bookhub.repository;

    opens br.com.senac.bookhub.service to javafx.fxml;
    exports br.com.senac.bookhub.service;

    opens br.com.senac.bookhub.view to javafx.graphics;
    exports br.com.senac.bookhub.view;

    opens br.com.senac.bookhub.controller to javafx.fxml;
    exports br.com.senac.bookhub.controller;

}