package com.study.studyprojects.codenamesclient.facade;

import com.study.studyprojects.codenamesclient.controller.SelectGameController;
import com.study.studyprojects.codenamesclient.service.GuiService;
import com.study.studyprojects.codenamesclient.utils.ControllerInfoContainer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LoginFacade {

    public static void goToSignUpScene() {

        try {

            GuiService.loadSignupScene();

        } catch (IOException e) {

            log.error("Failed to load signup scene. Thew IOException. Message: {}", e.getMessage());
            e.printStackTrace();

        }

    }

    public static void login(String username, String password) {

        try {

            ControllerInfoContainer.labelMap.put("labelUsername", username);
            GuiService.loadSelectGameScene();

        } catch (IOException e) {

            log.error("Failed to load select game scene. Threw IOException. Message: {}", e.getMessage());

        }

    }
}
