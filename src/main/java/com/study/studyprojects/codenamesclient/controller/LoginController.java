package com.study.studyprojects.codenamesclient.controller;

import com.study.studyprojects.codenamesclient.facade.LoginFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField tfUsername;

    @FXML
    private PasswordField pfPassword;

    @FXML
    public void onLoginButtonClick() {

        LoginFacade.login(tfUsername.getText(), pfPassword.getText());

        tfUsername.deleteText(0, tfUsername.getLength());
        pfPassword.deleteText(0, pfPassword.getLength());

    }

    @FXML
    public void onSignupButtonClick() {

        LoginFacade.goToSignUpScene();

    }

}
