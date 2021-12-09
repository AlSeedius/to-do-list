package com.alseed.todolist;

import com.alseed.todolist.commands.*;
import com.alseed.todolist.interfaces.ICommandFactory;
import com.alseed.todolist.interfaces.ITaskRepository;

public class CommandFactory implements ICommandFactory {

    @Override
    public BasicCommand createCommand(String commandName, ITaskRepository taskRepository) {
        switch (commandName.toLowerCase().trim()){
            case ("add"):
                return new Add(taskRepository);
            case ("delete"):
                return new Delete(taskRepository);
            case ("edit"):
                return new Edit(taskRepository);
            case ("print"):
                return new Print(taskRepository);
            case ("quit"):
                return new Quit(taskRepository);
            case ("toggle"):
                return new Toggle(taskRepository);
            case ("search"):
                return new Search(taskRepository);
            default:
                return null;
        }

    }

}
