package com.study.studyprojects.codenamesclient.controller;

import com.study.studyprojects.codenamesclient.facade.SelectGameFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SelectGameController {

    @FXML
    private Label labelUsername;

    @FXML
    public void onLogoutButtonClick() {

        labelUsername.setText("");

        SelectGameFacade.logout();

    }

    public void setUsername(String username) {
        labelUsername.setText(username);
    }


}
