package com.alseed.todolist.commands;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;

public class Quit extends BasicCommand {

    public Quit(ITaskRepository ITaskRepository) {
        super(ITaskRepository);
    }

    public void execute(){
        System.exit(1);
    }

    public boolean setArguments(Arguments arguments) {
        return true;
    }

}
