package com.alseed.todolist.commands;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;

public class Quit extends BasicCommand {

    public Quit(ITaskRepository ITaskRepository) {
        super(ITaskRepository);
        numOfArguments = 0;
        isIdFirstArgument = false;
        name = "quit";
    }

    public String execute(){
        System.exit(1);
        return "Выход из программы...";
    }

    public void setArguments(Arguments arguments) {
    }

}
