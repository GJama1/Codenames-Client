package com.study.studyprojects.codenamesclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    Button button;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        button.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.RED, null, null)));
    }
}