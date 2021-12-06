package com.alseed.todolist.workers;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.commands.*;

public class CommandFactory {

    public CommandFactory(){

    }

    public BasicCommand createCommand(String commandName, TaskRepository taskRepository, IOWorker ioWorker) {
        switch (commandName.toLowerCase().trim()){
            case ("add"):
                return new Add(taskRepository, ioWorker);
            case ("delete"):
                return new Delete(taskRepository, ioWorker);
            case ("edit"):
                return new Edit(taskRepository, ioWorker);
            case ("print"):
                return new Print(taskRepository, ioWorker);
            case ("quit"):
                return new Quit(taskRepository, ioWorker);
            case ("toggle"):
                return new Toggle(taskRepository, ioWorker);
            case ("search"):
                return new Search(taskRepository, ioWorker);
            default:
                return null;
        }

    }

}
