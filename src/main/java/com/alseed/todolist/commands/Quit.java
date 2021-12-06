package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.workers.IOWorker;

public class Quit extends BasicCommand {

    public Quit(TaskRepository taskRepository, IOWorker ioWorker) {
        super(taskRepository, ioWorker);
    }

    public void execute(){
        System.exit(1);
    }

    public boolean setArguments(Arguments arguments) {
        return true;
    }

}
