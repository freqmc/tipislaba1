package com.example.tipislaba1;

import com.example.tipislaba1.controller.appcontroller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.tipislaba1.model.LetterCounter;
import com.example.tipislaba1.view.counterview;

import java.io.IOException;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/tipislaba1/counter.fxml"));
        Parent root = loader.load();
        counterview view = loader.getController();
        LetterCounter model = new LetterCounter();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Счетчик русских букв (MVC)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
