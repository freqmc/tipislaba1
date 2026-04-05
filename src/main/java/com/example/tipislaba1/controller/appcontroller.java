package com.example.tipislaba1.controller;

import com.example.tipislaba1.model.LetterCounter;
import com.example.tipislaba1.view.counterview;
import javafx.fxml.FXML;

import java.util.Map;

public class appcontroller {

    // Ссылка на View будет инжектирована JavaFX автоматически, 
    // так как fx:controller указывает на этот класс? 
    // НЕТ. Обычно fx:controller указывает на View или отдельный класс.

    // ВАРИАНТ А: Если fx:controller="...counterview", то AppController должен быть отдельным объектом,
    // который мы связываем вручную. Но это сложно для новичка.

    // ВАРИАНТ Б (Рекомендуемый для вашей структуры): 
    // Сделаем AppController главным контроллером FXML, а counterview просто набором геттеров/сеттеров,
    // либо внедрим View внутрь AppController через @FXML, если они в одном файле.

    // ДАВАЙТЕ СДЕЛАЕМ ПРОЩЕ И НАДЕЖНЕЕ:
    // Пусть AppController реализует логику, а доступ к элементам получает через counterview,
    // который мы передадим ему ИЗ Main класса ПОСЛЕ загрузки FXML.

    private counterview view;
    private final LetterCounter model;

    public appcontroller(LetterCounter model) {
        this.model = model;
    }

    // Этот метод нужно вызвать из Main.java после загрузки FXML
    public void setView(counterview view) {
        this.view = view;
        // Сразу привязываем действие
        if (this.view != null) {
            this.view.setOnCountAction(this::handleCount);
        }
    }

    private void handleCount() {
        if (view == null) return;

        String text = view.getInputText();

        // 1. Общее количество
        int totalCount = model.countAllRussianLetters(text);
        view.setResult(String.format("Всего русских букв: %d", totalCount));

        // 2. Статистика
        Map<Character, Integer> letterStats = model.getAllLetterStatistics(text);

        if (letterStats.isEmpty()) {
            view.setStatistics("Русские буквы не найдены");
            view.setPercentages("Нет данных");
        } else {
            StringBuilder stats = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : letterStats.entrySet()) {
                stats.append(String.format("  %-3c : %3d\n", entry.getKey(), entry.getValue()));
            }
            view.setStatistics(stats.toString());

            // 3. Проценты
            Map<Character, Double> percentages = model.getLetterPercentages(text);
            StringBuilder percentOutput = new StringBuilder();
            for (Map.Entry<Character, Double> entry : percentages.entrySet()) {
                percentOutput.append(String.format("  %-3c : %5.2f%%\n", entry.getKey(), entry.getValue()));
            }
            view.setPercentages(percentOutput.toString());
        }
    }
}