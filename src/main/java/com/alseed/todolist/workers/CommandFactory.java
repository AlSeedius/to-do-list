package com.alseed.todolist.workers;

import com.alseed.todolist.commands.*;
import com.alseed.todolist.interfaces.TaskRepositoryInterface;

public class CommandFactory {

    public BasicCommand createCommand(String commandName, TaskRepositoryInterface taskRepositoryInterface, IOWorker ioWorker) {
        switch (commandName.toLowerCase().trim()){
            case ("add"):
                return new Add(taskRepositoryInterface, ioWorker);
            case ("delete"):
                return new Delete(taskRepositoryInterface, ioWorker);
            case ("edit"):
                return new Edit(taskRepositoryInterface, ioWorker);
            case ("print"):
                return new Print(taskRepositoryInterface, ioWorker);
            case ("quit"):
                return new Quit(taskRepositoryInterface, ioWorker);
            case ("toggle"):
                return new Toggle(taskRepositoryInterface, ioWorker);
            case ("search"):
                return new Search(taskRepositoryInterface, ioWorker);
            default:
                return null;
        }

    }

}
