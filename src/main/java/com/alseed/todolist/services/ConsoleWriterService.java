package com.alseed.todolist.services;

import com.alseed.todolist.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ConsoleWriterService {

    @Autowired
    LogWriterService logWriterService;

    public ConsoleWriterService(){}

    public void printTaskToConsole(Task task){
        System.out.println(printOutputCreator(task));
    }

    public void printTasksToConsole(Stream<Task> taskStream) {
        String print = (taskStream.map(ConsoleWriterService::printOutputCreator)
                .collect(Collectors.joining("\n")));
        System.out.println(print);
        logWriterService.logOutput(print);
    }

    static String getSymbol(boolean completed){
        if (completed)
            return "[x] ";
        else
            return "[] ";
    }

    static String printOutputCreator(Task task){
        return task.getId() + ". " + getSymbol(task.isCompleted()) + task.getDescription();
    }

    public void printWrongArgumentsMessage(){
        String message = "Неверно указаны аргументы к команде";
        System.out.println(message);
        logWriterService.logOutput(message);
    }

    public void printWrongCommandMessage(){
        String message = "Неверно указана команда";
        System.out.println(message);
        logWriterService.logOutput(message);
    }

    public void printWrongIdMessage() {
        String message = "Не найден указанный идентификатор";
        System.out.println(message);
        logWriterService.logOutput(message);
    }

    public void printMessage(String message){
        System.out.println(message);
        logWriterService.logOutput(message);
    }

}
