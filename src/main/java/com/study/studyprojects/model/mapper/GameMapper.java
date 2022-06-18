package com.study.studyprojects.model.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.studyprojects.model.dto.GameDto;

public class GameMapper {

    public static String mapToJson(GameDto object) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);

    }

    public static GameDto mapFromJson(String json) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, GameDto.class);

    }

}
