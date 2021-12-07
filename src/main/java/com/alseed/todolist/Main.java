package com.alseed.todolist;

import com.alseed.todolist.interfaces.IConsoleReader;
import com.alseed.todolist.interfaces.IIOWorker;
import com.alseed.todolist.presentationlayer.ConsoleReaderWorker;
import com.alseed.todolist.presentationlayer.IOWorker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        IIOWorker ioWorker = new IOWorker(args);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        IConsoleReader consoleReader = new ConsoleReaderWorker(ioWorker);
        consoleReader.startReadingConsole(bufferedReader);
    }
}
