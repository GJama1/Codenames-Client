package com.study.studyprojects.codenamesclient.service;

import com.study.studyprojects.codenamesclient.controller.GameController;
import com.study.studyprojects.codenamesclient.controller.SelectGameController;
import com.study.studyprojects.codenamesclient.utils.InfoContextHolder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

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

        String username = InfoContextHolder.labelMap.get("labelUsername");

        SelectGameController selectGameController = fxmlLoader.getController();
        selectGameController.setUsername(username);

        guiStage.setTitle("Codenames");
        guiStage.setScene(scene);
        guiStage.show();

        log.info("Select Game scene load successful");

    }

    public static void loadGameScene() throws IOException {

        log.info("Loading game scene");

        FXMLLoader fxmlLoader = new FXMLLoader(GuiService.class.getResource("/view/game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);

        String gameId = InfoContextHolder.game.getId().toString();
        String redSpymaster = InfoContextHolder.game.getRedSpymaster() != null ? InfoContextHolder.game.getRedSpymaster().getUsername() : "Spymaster";
        String blueSpymaster = InfoContextHolder.game.getBlueSpymaster() != null ? InfoContextHolder.game.getBlueSpymaster().getUsername() : "Spymaster";
        String redOperative = InfoContextHolder.game.getRedOperative() != null ? InfoContextHolder.game.getRedOperative().getUsername() : "Operative";
        String blueOperative = InfoContextHolder.game.getBlueOperative() != null ? InfoContextHolder.game.getBlueOperative().getUsername() : "Operative";

        GameController gameController = fxmlLoader.getController();

        gameController.setGameId(gameId);
        gameController.setRedOperative(redOperative);
        gameController.setRedSpymaster(redSpymaster);
        gameController.setBlueOperative(blueOperative);
        gameController.setBlueSpymaster(blueSpymaster);

        guiStage.setTitle("Codenames");
        guiStage.setScene(scene);
        guiStage.show();

        log.info("Game scene load successful");

    }

    public static void main(String[] args) {
        launch();
    }

}
