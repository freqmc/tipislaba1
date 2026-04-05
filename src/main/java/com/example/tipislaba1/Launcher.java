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
        // 1. Загружаем FXML
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("counter.fxml"));

        // 2. Создаем Модель и Контроллер вручную
        model = new LetterCounter();
        appController = new appcontroller(model);

        // 3. Важно: Указываем FXMLLoader'у, какой контроллер использовать?
        // НЕТ, если в FXML уже указан fx:controller="com.example.tipislaba1.view.CounterView".
        // В таком случае FXMLLoader создаст экземпляр CounterView.

        // Загружаем сцену
        Scene scene = new Scene(fxmlLoader.load(), 550, 700);
        stage.setTitle("Анализ текста");
        stage.setScene(scene);
        stage.show();

        // 4. ПОЛУЧАЕМ созданный JavaFX экземпляр View из Loader'а
        counterview view = fxmlLoader.getController();

        // 5. СВЯЗЫВАЕМ их
        appController.setView(view);
    }

    public static void main(String[] args) {
        launch();
    }
}