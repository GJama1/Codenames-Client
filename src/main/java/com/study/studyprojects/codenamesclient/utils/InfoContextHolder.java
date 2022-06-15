package com.study.studyprojects.codenamesclient.utils;

import com.study.studyprojects.model.dto.UserDto;

import java.util.HashMap;
import java.util.Map;

public class InfoContextHolder {

    public static Map<String, String> labelMap = new HashMap<>();

    public static UserDto principal;

}
