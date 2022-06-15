package com.study.studyprojects.codenamesclient.utils;

import com.study.studyprojects.model.Message;

import java.io.ObjectInputStream;
import java.util.Optional;

public class MessageConsumer {

    public static Optional<Message> consumeMessage(ObjectInputStream in) throws Exception {

        return Optional.of((Message) in.readObject());
    }

}
