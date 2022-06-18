package com.study.studyprojects.codenamesclient.utils;

import com.study.studyprojects.codenamesclient.thread.MessageConsumerThread;
import com.study.studyprojects.model.dto.GameDto;
import com.study.studyprojects.model.dto.UserDto;

import java.util.HashMap;
import java.util.Map;

public class InfoContextHolder {

    public static Map<String, String> labelMap = new HashMap<>();

    public static UserDto principal;

    public static GameDto game;

    public static MessageConsumerThread messageConsumerThread;

}
