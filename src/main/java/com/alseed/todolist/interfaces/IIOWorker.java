package com.alseed.todolist.interfaces;

public interface IIOWorker {

    void printAndLogOutput(String message);

    void printAndLogOutput(Exception e);

    void logInput(String inputLine);
}
