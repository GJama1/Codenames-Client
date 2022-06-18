package com.study.studyprojects.codenamesclient.facade;

import com.study.studyprojects.codenamesclient.service.GuiService;
import com.study.studyprojects.codenamesclient.thread.MessageConsumerThread;
import com.study.studyprojects.codenamesclient.utils.InfoContextHolder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class GameFacade {

    public static void leaveGame() {

        try {

            //InfoContextHolder.messageConsumerThread.interrupt();
            //InfoContextHolder.messageConsumerThread = null;

            InfoContextHolder.game = null;
            GuiService.loadSelectGameScene();

        }
        catch (IOException e) {
            log.error("Failed to load select game scene. Threw IOException. Message: {}", e.getMessage());
            e.printStackTrace();
        }

    }
}
