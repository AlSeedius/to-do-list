package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.ITaskRepository;

public class Quit extends BasicCommand {

    public Quit(ITaskRepository ITaskRepository) {
        super(ITaskRepository);
    }

    public String execute(){
        System.exit(1);
        return "Выход из программы...";
    }

}
