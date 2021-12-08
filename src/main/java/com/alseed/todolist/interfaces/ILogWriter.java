package com.alseed.todolist.interfaces;

public interface ILogWriter {

    void logInput(String inputLine);

    void logOutput(String inputLine);

    void logException(Exception e);
}
