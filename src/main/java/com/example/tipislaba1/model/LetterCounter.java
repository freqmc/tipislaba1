package com.example.tipislaba1.model;

import java.util.Map;
import java.util.TreeMap;

public class LetterCounter {
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
}