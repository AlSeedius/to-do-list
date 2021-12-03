package com.alseed.todolist.interfaces;

import com.alseed.todolist.entities.Task;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ConsoleWriter {

    default void printTaskToConsole(Task task){
        System.out.println(printOutputCreator(task));
    }

    default void printTasksToConsole(Stream<Task> taskStream) {
        System.out.println(taskStream.map(ConsoleWriter::printOutputCreator)
                .collect(Collectors.joining("\n")));
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

    default void printWrongArgumentsMessage(){
        System.out.println("Неверно указаны аргументы к команде");
    }

    default void printWrongCommandMessage(){
        System.out.println("Неверно указана команда");
    }

    default void printWrongIdMessage() {System.out.println("Не найден указанный идентификатор");}
}