package com.study.studyprojects.codenamesclient.facade;

import com.study.studyprojects.codenamesclient.service.GuiService;
import com.study.studyprojects.codenamesclient.utils.InfoContextHolder;
import com.study.studyprojects.codenamesclient.utils.MessageConsumer;
import com.study.studyprojects.codenamesclient.utils.SocketStreams;
import com.study.studyprojects.model.Message;
import com.study.studyprojects.model.MessageCodes;
import com.study.studyprojects.model.dto.UserDto;
import com.study.studyprojects.model.mapper.UserAuthMapper;
import com.study.studyprojects.model.mapper.UserDtoMapper;
import com.study.studyprojects.model.param.UserAuthParam;
import javafx.scene.control.Alert;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

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

        if (username.isBlank()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username cannot be blank!");
            alert.show();
            return;
        }
        else if (password.isBlank()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Password cannot be blank!");
            alert.show();
            return;

        }

        try {

            ObjectOutputStream out = SocketStreams.out;
            ObjectInputStream in = SocketStreams.in;

            UserAuthParam param = new UserAuthParam(username, password);

            String paramJson = UserAuthMapper.mapToJson(param);
            Message requestMessage = new Message(MessageCodes.LOGIN_REQUEST, paramJson);

            out.writeObject(requestMessage);
            out.flush();

            while(SocketStreams.socket.isConnected()) {

                Optional<Message> responseMessage = MessageConsumer.consumeMessage(in);

                if (responseMessage.isPresent()) {

                    Message response = responseMessage.get();

                    if (response.getCode().equals(MessageCodes.UNAUTHORIZED)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Invalid credentials!");
                        alert.show();
                        return;
                    }
                    else if (response.getCode().equals(MessageCodes.OK)) {

                        UserDto userDto = UserDtoMapper.mapFromJson(response.getBody());

                        InfoContextHolder.principal = userDto;
                        InfoContextHolder.labelMap.put("labelUsername", userDto.getUsername());

                        GuiService.loadSelectGameScene();
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
