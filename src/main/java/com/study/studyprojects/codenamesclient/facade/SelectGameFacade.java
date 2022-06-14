package com.study.studyprojects.codenamesclient.facade;

import com.study.studyprojects.codenamesclient.service.GuiService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class SelectGameFacade {


    public static void goToLoginScene() {

        try {

            GuiService.loadLoginScene();

        } catch (IOException e) {

            log.error("Failed to load login scene. Threw IOException. Message: {}", e.getMessage());
            e.printStackTrace();

        }


    }
}
