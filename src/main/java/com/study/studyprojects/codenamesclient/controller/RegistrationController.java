package com.study.studyprojects.codenamesclient.controller;

import com.study.studyprojects.codenamesclient.facade.RegistrationFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {


    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField pfPassword;


    @FXML
    public void onSignupButtonClick() {

        RegistrationFacade.signUp(tfUsername.getText(), pfPassword.getText());

        tfUsername.deleteText(0, tfUsername.getLength());
        pfPassword.deleteText(0, pfPassword.getLength());

    }

    @FXML void onLoginButtonClick() {

        RegistrationFacade.goToLoginScene();

    }

}
