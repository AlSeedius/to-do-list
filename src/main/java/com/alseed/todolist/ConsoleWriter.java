package com.alseed.todolist;

public class ConsoleWriter {

    public void writeToConsole(String line){
        if (line.length()>0)
        System.out.println(line);
    }
}
