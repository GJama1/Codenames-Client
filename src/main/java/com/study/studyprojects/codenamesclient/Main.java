package com.study.studyprojects.codenamesclient;

import com.study.studyprojects.codenamesclient.controller.SelectGameController;
import com.study.studyprojects.codenamesclient.service.GuiService;
import com.study.studyprojects.codenamesclient.utils.SocketStreams;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

@Slf4j
public class Main {

    private static void connectWithServer() {

        try (InputStream is = Main.class.getResourceAsStream("/application.properties")) {

            Properties props = new Properties();
            props.load(is);

            String serverUrl = props.getProperty("server.url");
            int serverPort = Integer.parseInt(props.getProperty("server.port"));

            Socket socket = new Socket(serverUrl, serverPort);
            SocketStreams.out = new ObjectOutputStream(socket.getOutputStream());
            SocketStreams.in = new ObjectInputStream(socket.getInputStream());

        }
        catch (IOException e) {
            log.error("Error loading application.properties. Message: {}. StackTrace: {}", e.getMessage(), e.getStackTrace());
            e.printStackTrace();
        }

    }

    public static void main( String[] args ) {

        connectWithServer();

        GuiService.main(args);
    }

}
