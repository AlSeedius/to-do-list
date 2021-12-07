package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.TaskRepositoryInterface;
import com.alseed.todolist.workers.IOWorker;

public class Quit extends BasicCommand {

    public Quit(TaskRepositoryInterface taskRepositoryInterface, IOWorker ioWorker) {
        super(taskRepositoryInterface, ioWorker);
    }

    public void execute(){
        System.exit(1);
    }

    public boolean setArguments(Arguments arguments) {
        return true;
    }

}
