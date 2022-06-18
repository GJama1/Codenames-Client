package com.study.studyprojects.codenamesclient.controller;

import com.study.studyprojects.codenamesclient.facade.GameFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {

    @FXML
    private Label labelGameId;
    @FXML
    private Label labelRedOperative;
    @FXML
    private Label labelRedSpymaster;
    @FXML
    private Label labelBlueOperative;
    @FXML
    private Label labelBlueSpymaster;


    public void setGameId(String id) {
        labelGameId.setText(id);
    }
    public void setRedOperative(String redOperative) {
        labelRedOperative.setText(redOperative);
    }
    public void setRedSpymaster(String redSpymaster) {
        labelRedSpymaster.setText(redSpymaster);
    }
    public void setBlueOperative(String blueOperative) {
        labelBlueOperative.setText(blueOperative);
    }
    public void setBlueSpymaster(String blueSpymaster) {
        labelBlueSpymaster.setText(blueSpymaster);
    }


    @FXML
    public void onLeaveGameButtonClick() {

        labelGameId.setText("");
        GameFacade.leaveGame();
    }

}
