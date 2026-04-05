package com.example.tipislaba1.controller;

import com.example.tipislaba1.model.LetterCounter;
import com.example.tipislaba1.view.counterview;
import javafx.fxml.FXML;

import java.util.Map;

public class appcontroller {
    private counterview view;
    private final LetterCounter model;

    public appcontroller(LetterCounter model) {
        this.model = model;
    }

    public void setView(counterview view) {
        this.view = view;
        if (this.view != null) {
            this.view.setOnCountAction(this::handleCount);
        }
    }

    private void handleCount() {
        if (view == null) return;

        String text = view.getInputText();

        int totalCount = model.countAllRussianLetters(text);
        view.setResult(String.format("Всего русских букв: %d", totalCount));

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

            Map<Character, Double> percentages = model.getLetterPercentages(text);
            StringBuilder percentOutput = new StringBuilder();
            for (Map.Entry<Character, Double> entry : percentages.entrySet()) {
                percentOutput.append(String.format("  %-3c : %5.2f%%\n", entry.getKey(), entry.getValue()));
            }
            view.setPercentages(percentOutput.toString());
        }
    }
}