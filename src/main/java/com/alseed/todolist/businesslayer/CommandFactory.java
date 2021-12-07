package com.alseed.todolist.businesslayer;

import com.alseed.todolist.commands.*;
import com.alseed.todolist.interfaces.ICommandFactory;
import com.alseed.todolist.interfaces.IIOWorker;
import com.alseed.todolist.interfaces.ITaskRepository;

public class CommandFactory implements ICommandFactory {

    @Override
    public BasicCommand createCommand(String commandName, ITaskRepository taskRepositoryImpl) {
        switch (commandName.toLowerCase().trim()){
            case ("add"):
                return new Add(taskRepositoryImpl);
            case ("delete"):
                return new Delete(taskRepositoryImpl);
            case ("edit"):
                return new Edit(taskRepositoryImpl);
            case ("print"):
                return new Print(taskRepositoryImpl);
            case ("quit"):
                return new Quit(taskRepositoryImpl);
            case ("toggle"):
                return new Toggle(taskRepositoryImpl);
            case ("search"):
                return new Search(taskRepositoryImpl);
            default:
                return null;
        }

    }

}
