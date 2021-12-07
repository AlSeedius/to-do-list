package com.alseed.todolist.interfaces;

import com.alseed.todolist.entities.Task;

import java.util.stream.Stream;

public interface IIOWorker {

    void printAndLogOutput(String message);

    void printAndLogOutput(Exception e);

    void logInput(String inputLine);
}
