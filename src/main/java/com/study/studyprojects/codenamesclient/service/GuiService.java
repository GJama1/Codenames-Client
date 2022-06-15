package com.study.studyprojects.codenamesclient.service;

import com.study.studyprojects.codenamesclient.controller.LoginController;
import com.study.studyprojects.codenamesclient.controller.RegistrationController;
import com.study.studyprojects.codenamesclient.controller.SelectGameController;
import com.study.studyprojects.codenamesclient.facade.LoginFacade;
import com.study.studyprojects.codenamesclient.utils.ControllerInfoContainer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GuiService extends Application {

    private static Stage guiStage;

    @Override
    public void start(Stage stage) throws IOException {

        log.info("Loading initial scene");

        FXMLLoader fxmlLoader = new FXMLLoader(GuiService.class.getResource("/view/registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);

        guiStage = stage;
        guiStage.setTitle("Codenames");
        guiStage.setScene(scene);
        guiStage.show();

        log.info("Initial scene load successful");

    }
    public static void loadLoginScene() throws IOException {

        log.info("Loading login scene");

        FXMLLoader fxmlLoader = new FXMLLoader(GuiService.class.getResource("/view/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);

        guiStage.setTitle("Codenames");
        guiStage.setScene(scene);
        guiStage.show();

        log.info("Login scene load successful");

    }

    public static void loadSignupScene() throws IOException {

        log.info("Loading signup scene");

        FXMLLoader fxmlLoader = new FXMLLoader(GuiService.class.getResource("/view/registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);

        guiStage.setTitle("Codenames");
        guiStage.setScene(scene);
        guiStage.show();

        log.info("Signup scene load successful");

    }

    public static void loadSelectGameScene() throws IOException {

        log.info("Loading select game scene");

        FXMLLoader fxmlLoader = new FXMLLoader(GuiService.class.getResource("/view/selectgame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);

        String username = ControllerInfoContainer.labelMap.get("labelUsername");

        SelectGameController selectGameController = fxmlLoader.getController();
        selectGameController.setUsername(username);

        guiStage.setTitle("Codenames");
        guiStage.setScene(scene);
        guiStage.show();

        log.info("Select Game scene load successful");

    }

    public static void main(String[] args) {
        launch();
    }

}
