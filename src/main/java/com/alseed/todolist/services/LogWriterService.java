package com.alseed.todolist.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

@Controller
public class LogWriterService {
    private Logger logger = LoggerFactory.getLogger(LogWriterService.class);
    private boolean loggingEnabled;

    public LogWriterService() { }

    public void setLoggingEnabled(String[] args) {
        this.loggingEnabled = Arrays.stream(args).anyMatch(s -> s.equals("log"));
    }

    public void logInput(String inputLine){
        if (inputLine.length() > 0 && loggingEnabled)
            logger.debug("{} {}", "input:", inputLine);
    }

    public void logOutput(String inputLine){
        if (inputLine.length() > 0 && loggingEnabled)
            logger.debug("{} {}", "output:", inputLine);
    }

    public void logException(Exception e){
        logger.error(e.toString());
    }
}
