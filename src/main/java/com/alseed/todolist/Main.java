package com.alseed.todolist;

import com.alseed.todolist.workers.IOWorker;
import com.alseed.todolist.workers.MainLogicImplementator;

public class Main {
    public static void main(String[] args) {
        IOWorker ioWorker = new IOWorker(args);
        new MainLogicImplementator(ioWorker).startWorking();
    }
}
