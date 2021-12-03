package com.alseed.todolist;

import com.alseed.todolist.workers.CommandList;
import com.alseed.todolist.workers.LogWriter;
import com.alseed.todolist.workers.Parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        LogWriter logWriter = new LogWriter(args);
        CommandList cl =  new CommandList();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Parser p = new Parser(bufferedReader, cl, logWriter);
    }
}
