package com.study.studyprojects.codenamesclient.facade;

import com.study.studyprojects.codenamesclient.service.GuiService;
import com.study.studyprojects.codenamesclient.thread.MessageConsumerThread;
import com.study.studyprojects.codenamesclient.utils.InfoContextHolder;
import com.study.studyprojects.codenamesclient.utils.MessageConsumer;
import com.study.studyprojects.codenamesclient.utils.SocketStreams;
import com.study.studyprojects.model.Message;
import com.study.studyprojects.model.MessageCodes;
import com.study.studyprojects.model.dto.GameDto;
import com.study.studyprojects.model.mapper.CreateGameMapper;
import com.study.studyprojects.model.mapper.GameMapper;
import com.study.studyprojects.model.param.CreateGameParam;
import javafx.scene.control.Alert;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Optional;

@Slf4j
public class SelectGameFacade {


    public static void logout() {

        try {

            InfoContextHolder.principal = null;
            GuiService.loadLoginScene();

        } catch (IOException e) {

            log.error("Failed to load login scene. Threw IOException. Message: {}", e.getMessage());
            e.printStackTrace();

        }


    }

    public static void createGame() {

        if (InfoContextHolder.principal == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You must be logged in to create a game!");
            alert.show();

            return;
        }



        try {

            long ownerId = InfoContextHolder.principal.getId();

            ObjectOutputStream out = SocketStreams.out;
            ObjectInputStream in = SocketStreams.in;
            Socket socket = SocketStreams.socket;

            String body = CreateGameMapper.mapToJson(new CreateGameParam(ownerId));

            Message request = new Message(MessageCodes.CREATE_GAME_REQUEST, body);

            out.writeObject(request);
            out.flush();

            while(socket.isConnected()) {

                Optional<Message> response = MessageConsumer.consumeMessage(in);

                if (response.isPresent()) {

                    Message msg = response.get();

                    if (msg.getCode().equals(MessageCodes.INTERNAL_SERVER_ERROR)) {

                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Failed to create game!");
                        alert.show();
                        return;

                    }
                    else if (msg.getCode().equals(MessageCodes.CREATED)) {

                        GameDto game = GameMapper.mapFromJson(msg.getBody());

                        InfoContextHolder.game = game;

                        GuiService.loadGameScene();
                        //InfoContextHolder.messageConsumerThread = new MessageConsumerThread(in, socket);

                        return;
                    }

                }

            }

        }
        catch (Exception e) {
            log.error("Failed to create game. Threw Exception. Message: {}", e.getMessage());
            e.printStackTrace();
        }

    }
}
