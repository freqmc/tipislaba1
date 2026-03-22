module com.example.tipislaba1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tipislaba1 to javafx.fxml;
    exports com.example.tipislaba1;
    exports com.example.tipislaba1.model;
    opens com.example.tipislaba1.model to javafx.fxml;
    exports com.example.tipislaba1.controller;
    opens com.example.tipislaba1.controller to javafx.fxml;
    opens com.example.tipislaba1.view to javafx.fxml;
}