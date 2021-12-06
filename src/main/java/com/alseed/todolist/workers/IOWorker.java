package com.alseed.todolist.workers;

import com.alseed.todolist.entities.Task;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOWorker {

    private LogWriter logWriter;
    private ConsoleWriter consoleWriter;

    public IOWorker(String[] args){
        this.logWriter = new LogWriter(args);
        this.consoleWriter = new ConsoleWriter();
    }

    public void printAndLogOutput(String message){
        logWriter.logOutput(message);
        consoleWriter.printMessage(message);
    }

    public void printAndLogOutput(Stream<Task> taskStream){
        String printLine = taskOutputList(taskStream);
        logWriter.logOutput(printLine);
        consoleWriter.printMessage(printLine);
    }

    public void printAndLogOutput(Exception e) {
        logWriter.logException(e);
        consoleWriter.printMessage(e.getMessage());
    }

    public void logInput(String inputLine){
        logWriter.logInput(inputLine);
    }

    private static String getSymbol(boolean completed){
        if (completed)
            return "[x] ";
        else
            return "[] ";
    }

    private static String printOutputCreator(Task task){
        return task.getId() + ". " + getSymbol(task.isCompleted()) + task.getDescription();
    }

    private String taskOutputList(Stream<Task> taskStream) {
        return taskStream.map(com.alseed.todolist.workers.IOWorker::printOutputCreator)
                .collect(Collectors.joining("\n"));
    }

}

/*
    public void printWrongArgumentsMessage(){
        System.out.println("Неверно указаны аргументы к команде");
    }

    public void printWrongCommandMessage(){
        System.out.println("Неверно указана команда");
    }

    public void printWrongIdMessage() {System.out.println("Не найден указанный идентификатор");}*/
