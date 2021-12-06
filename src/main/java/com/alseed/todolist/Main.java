package com.alseed.todolist;

import com.alseed.todolist.workers.IOWorker;
import com.alseed.todolist.workers.LogWriter;
import com.alseed.todolist.workers.Parser;

public class Main {
    public static void main(String[] args) {
        IOWorker ioWorker = new IOWorker(args);
        new Parser(ioWorker).startParsing();
    }
}
