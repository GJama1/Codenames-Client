package com.study.studyprojects.codenamesclient.controller;

import com.study.studyprojects.codenamesclient.facade.RegistrationFacade;
import javafx.fxml.FXML;

public class RegistrationController {



    @FXML
    public void onSignupButtonClick() {

    }

    @FXML void onLoginButtonClick() {

        RegistrationFacade.goToLoginScene();

    }

}
