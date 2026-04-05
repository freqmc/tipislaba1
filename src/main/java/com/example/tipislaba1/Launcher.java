package com.example.tipislaba1;

import com.example.tipislaba1.controller.appcontroller;
import com.example.tipislaba1.model.LetterCounter;
import com.example.tipislaba1.view.counterview;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    private appcontroller appController;
    private LetterCounter model;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("counter.fxml"));

        model = new LetterCounter();
        appController = new appcontroller(model);

        Scene scene = new Scene(fxmlLoader.load(), 550, 700);
        stage.setTitle("Анализ текста");
        stage.setScene(scene);
        stage.show();

        counterview view = fxmlLoader.getController();

        appController.setView(view);
    }

    public static void main(String[] args) {
        launch();
    }
}