package com.alseed.todolist.businesslayer;

import com.alseed.todolist.commands.BasicCommand;
import com.alseed.todolist.entities.WrongArgumentException;
import com.alseed.todolist.interfaces.*;
import com.alseed.todolist.datasourcelayer.TaskAsListRepository;

public class MainLogicImplementor {

    private static MainLogicImplementor instance;

    private MainLogicImplementor(){}

    public static MainLogicImplementor getInstance(){
        if (instance==null)
            instance = new MainLogicImplementor();
        return instance;
    }

    public String commandExecutionOutput(IParser p){
        if (CommandSeeker.getInstance().commandExists(p.getParsedCommandName())){
            ITaskRepository taskRepository = TaskAsListRepository.getInstance();
            BasicCommand command = CommandFactory.getInstance().createCommand(p.getParsedCommandName(), taskRepository);
            try{
                command.setArguments(ArgumentSetter.getInstance().argumentList(command, p.getParsedCommandArguments(), taskRepository));
                return command.execute();
            }
            catch (WrongArgumentException e){
                return e.getMessage();
            }
        }
        else return "Не найдена указанная команда.";
    }
}

