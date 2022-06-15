package com.study.studyprojects.codenamesclient.facade;

import com.study.studyprojects.codenamesclient.service.GuiService;
import com.study.studyprojects.codenamesclient.utils.MessageConsumer;
import com.study.studyprojects.codenamesclient.utils.SocketStreams;
import com.study.studyprojects.model.Message;
import com.study.studyprojects.model.MessageCodes;
import com.study.studyprojects.model.mapper.UserAuthMapper;
import com.study.studyprojects.model.param.UserAuthParam;
import javafx.scene.control.Alert;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

@Slf4j
public class RegistrationFacade {

    public static void goToLoginScene() {

        try {

            GuiService.loadLoginScene();

        } catch (IOException e) {

            log.error("Failed to load login scene. Threw IOException. Message: {}", e.getMessage());
            e.printStackTrace();

        }

    }

    public static void signUp(String username, String password) {

        if (username.isBlank()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Username cannot be blank!");
            alert.show();
            return;
        }
        else if (password.isBlank()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Password cannot be blank!");
            alert.show();
            return;

        }



        try {

            ObjectOutputStream out = SocketStreams.out;
            ObjectInputStream in = SocketStreams.in;

            UserAuthParam param = new UserAuthParam(username, password);

            String paramJson = UserAuthMapper.mapToJson(param);
            Message requestMessage = new Message(MessageCodes.SIGN_UP_REQUEST, paramJson);

            out.writeObject(requestMessage);
            out.flush();

            while (SocketStreams.socket.isConnected()) {

                Optional<Message> responseMessage = MessageConsumer.consumeMessage(in);

                if (responseMessage.isPresent()) {
                    Message response = responseMessage.get();

                    if (response.getCode().equals(MessageCodes.CREATED)) {

                        GuiService.loadLoginScene();
                        return;
                    }
                    else if (response.getCode().equals(MessageCodes.CONFLICT)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Username already exists!");
                        alert.show();
                        return;
                    } else if(response.getCode().equals(MessageCodes.INTERNAL_SERVER_ERROR)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Failed to create user!");
                        alert.show();
                        return;
                    }

                }

            }
        }
        catch (Exception e) {
            log.error("Method threw an exception. Message: {}", e.getMessage());
            e.printStackTrace();
        }





    }
}
