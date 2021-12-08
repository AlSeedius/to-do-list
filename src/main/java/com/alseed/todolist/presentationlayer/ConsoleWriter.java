package com.alseed.todolist.presentationlayer;

import com.alseed.todolist.interfaces.IConsoleWriter;

public class ConsoleWriter implements IConsoleWriter {

    @Override
    public void printMessage(String message){
        System.out.println(message);
    }
}
