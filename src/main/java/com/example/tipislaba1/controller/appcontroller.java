package com.example.tipislaba1.controller;

import com.example.tipislaba1.model.LetterCounter;
import com.example.tipislaba1.view.counterview;

import java.util.Map;

public class appcontroller {

    private final counterview view;
    private final LetterCounter model;

    public appcontroller(counterview view, LetterCounter model) {
        this.view = view;
        this.model = model;

        view.setOnCountAction(this::handleCount);
    }

    private void handleCount() {
        String text = view.getInputText();

        int totalCount = model.countAllRussianLetters(text);
        view.setResult("Всего русских букв: " + totalCount);

        Map<Character, Integer> letterStats = model.getAllLetterStatistics(text);

        if (letterStats.isEmpty()) {
            view.setStatistics("Русские буквы не найдены");
        } else {
            StringBuilder stats = new StringBuilder();
            for (Map.Entry<Character, Integer> entry : letterStats.entrySet()) {
                stats.append(String.format("  %c : %d\n", entry.getKey(), entry.getValue()));
            }
            view.setStatistics(stats.toString());
        }
    }
}