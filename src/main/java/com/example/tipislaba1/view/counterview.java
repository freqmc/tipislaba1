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

    public String getInputText() {
        return textArea.getText();
    }

    public void setResult(String message) {
        resultLabel.setText(message);
    }

    public void setStatistics(String stats) {
        statisticsArea.setText(stats);
    }

    public void setOnCountAction(Runnable action) {
        countButton.setOnAction(e -> action.run());
    }

    @FXML
    private void initialize() {
        statisticsArea.setEditable(false);
        statisticsArea.setPrefRowCount(10);
    }
}