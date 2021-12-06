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
        StringBuilder sb = new StringBuilder();
        sb.append(task.getId());
        sb.append(". ");
        sb.append(getSymbol(task.isCompleted()));
        sb.append(task.getDescription());
        return sb.toString();
    }

    private String taskOutputList(Stream<Task> taskStream) {
        return taskStream.map(com.alseed.todolist.workers.IOWorker::printOutputCreator)
                .collect(Collectors.joining("\n"));
    }

}