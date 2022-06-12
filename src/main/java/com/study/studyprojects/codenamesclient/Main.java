package com.study.studyprojects.codenamesclient;

import com.study.studyprojects.codenamesclient.GuiLoader;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main
{
    public static void main( String[] args )
    {

        log.info("Loaded");
        GuiLoader.main(args);

    }
}