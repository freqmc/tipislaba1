package com.example.tipislaba1.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class counterview {

    @FXML private VBox root;
    @FXML private TextArea textArea;
    @FXML private Button countButton;
    @FXML private Label resultLabel;
    @FXML private TextArea statisticsArea;
    @FXML private TextArea percentagesArea;

    public String getInputText() {
        return textArea != null ? textArea.getText() : "";
    }

    public void setResult(String message) {
        if (resultLabel != null) {
            resultLabel.setText(message);
        }
    }

    public void setStatistics(String stats) {
        if (statisticsArea != null) {
            statisticsArea.setText(stats);
        }
    }

    public void setPercentages(String percentages) {
        if (percentagesArea != null) {
            percentagesArea.setText(percentages);
        }
    }

    public void setOnCountAction(Runnable action) {
        if (countButton != null) {
            countButton.setOnAction(e -> {
                try {
                    action.run();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    setResult("Ошибка: " + ex.getMessage());
                }
            });
        }
    }

    @FXML
    private void initialize() {
        if (statisticsArea != null) {
            statisticsArea.setEditable(false);
            statisticsArea.setPrefRowCount(8);
        }
        if (percentagesArea != null) {
            percentagesArea.setEditable(false);
            percentagesArea.setPrefRowCount(8);
        }
    }
}