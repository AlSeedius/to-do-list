package com.alseed.todolist.workers;

import com.alseed.todolist.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class LogWriter {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static boolean loggingEnabled;

    public LogWriter(String[] args){
        this.loggingEnabled = Arrays
                .stream(args)
                .anyMatch(s -> s.equals("log"));
    }

    public void logInput(String inputLine){
        if (inputLine.length() > 0 && loggingEnabled)
            LOGGER.debug("input: {}", inputLine);
    }

    public void logOutput(String inputLine){
        if (inputLine.length() > 0 && loggingEnabled)
            LOGGER.debug("output: {}", inputLine);
    }

    public void logException(Exception e){
        LOGGER.error(e.toString());
    }
}