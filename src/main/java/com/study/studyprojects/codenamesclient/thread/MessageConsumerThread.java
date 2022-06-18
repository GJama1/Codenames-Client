package com.study.studyprojects.codenamesclient.thread;

import com.study.studyprojects.codenamesclient.utils.MessageConsumer;
import com.study.studyprojects.model.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Optional;

@Getter
@Setter
@Slf4j
public class MessageConsumerThread extends Thread {

    private ObjectInputStream in;
    private Socket socket;

    public MessageConsumerThread(ObjectInputStream in, Socket socket) {

        this.in = in;
        this.socket = socket;

        start();
    }


    @Override
    public void run() {

        try {

            while(socket.isConnected()) {

                Optional<Message> response = MessageConsumer.consumeMessage(in);

                if (response.isPresent()) {



                }

            }

        }
        catch (Exception e) {
            log.error("Threw an exception. Message: {}", e.getMessage());
            e.printStackTrace();
        }

    }
}
