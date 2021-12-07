package com.alseed.todolist.presentationlayer;

import com.alseed.todolist.interfaces.IConsoleWriter;
import com.alseed.todolist.interfaces.IIOWorker;
import com.alseed.todolist.interfaces.ILogWriter;
import com.alseed.todolist.crosscuttinglayer.LogWriter;

public class IOWorker implements IIOWorker {

    private ILogWriter logWriter;
    private IConsoleWriter consoleWriter;

    public IOWorker(String[] args){
        this.logWriter = new LogWriter(args);
        this.consoleWriter = new ConsoleWriter();
    }

    @Override
    public void printAndLogOutput(String message){
        logWriter.logOutput(message);
        consoleWriter.printMessage(message);
    }

    @Override
    public void printAndLogOutput(Exception e) {
        logWriter.logException(e);
        consoleWriter.printMessage(e.getMessage());
    }

    @Override
    public void logInput(String inputLine){
        logWriter.logInput(inputLine);
    }

}