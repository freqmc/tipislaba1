package com.example.tipislaba1.model;

import java.util.Map;
import java.util.TreeMap;

public class LetterCounter {

    /**
     * Подсчитывает общее количество русских букв в тексте.
     */
    public int countAllRussianLetters(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (char c : text.toCharArray()) {
            if (c >= '\u0400' && c <= '\u04FF') {
                count++;
            }
        }
        return count;
    }

    /**
     * Возвращает статистику встречаемости каждой русской буквы (регистронезависимо).
     */
    public Map<Character, Integer> getAllLetterStatistics(String text) {
        Map<Character, Integer> stats = new TreeMap<>();

        if (text == null || text.isEmpty()) {
            return stats;
        }

        for (char c : text.toLowerCase().toCharArray()) {
            if (c >= '\u0400' && c <= '\u04FF') {
                stats.put(c, stats.getOrDefault(c, 0) + 1);
            }
        }
        return stats;
    }

    /**
     * Вычисляет процент встречаемости каждой русской буквы в тексте.
     * @return Map<Character, Double> где значение — процент (0.0–100.0)
     */
    public Map<Character, Double> getLetterPercentages(String text) {
        Map<Character, Double> percentages = new TreeMap<>();
        int totalRussianLetters = countAllRussianLetters(text);

        if (totalRussianLetters == 0) {
            return percentages;
        }

        Map<Character, Integer> stats = getAllLetterStatistics(text);

        for (Map.Entry<Character, Integer> entry : stats.entrySet()) {
            double percentage = ((double) entry.getValue() / totalRussianLetters) * 100;
            percentages.put(entry.getKey(), percentage);
        }
        return percentages;
    }
}