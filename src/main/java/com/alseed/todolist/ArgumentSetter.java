package com.alseed.todolist;

import com.alseed.todolist.entities.CommandInfo;
import com.alseed.todolist.entities.WrongArgumentException;
import com.alseed.todolist.interfaces.IArgumentErrorHandler;
import com.alseed.todolist.interfaces.ITaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArgumentSetter {

    private Optional<String[]> arguments;
    private ITaskRepository taskRepository;
    private CommandInfo command;
    private IArgumentErrorHandler argumentErrorHandler;

    public ArgumentSetter(Optional<String[]> arguments, ITaskRepository taskRepository, CommandInfo commandInfo){
        this.arguments = arguments;
        this.taskRepository = taskRepository;
        this.command = commandInfo;
        this.argumentErrorHandler = new ArgumentErrorHandler();
    }

    public List<String> getArgumentList()
            throws WrongArgumentException {
        List<String> argumentList;
        if ((command.getName().equals("print") || command.getName().equals("quit")) && !arguments.isPresent())
            return null;
        else if (command.getNumberOfArguments() == 1)
            argumentList = oneArgumentArray();
        else
            argumentList = twoArgumentsArray();
        return argumentList;
    }

    private static String concatArray(String[] input, int nStart) {
        return IntStream.range(nStart, input.length)
                .mapToObj((s) -> input[s])
                .collect(Collectors.joining(" "));
    }

    private List<String> oneArgumentArray() throws WrongArgumentException {
        List<String> arrayToReturn = new ArrayList<>();
        if (command.getIdFirstArgument())
            argumentErrorHandler.checkIfIdIsWrong(arguments.get()[0], taskRepository);
        if (command.getName().equals("print") && !arguments.get()[0].equals("all"))
            throw new WrongArgumentException("Указан неверный аргумент");
        arrayToReturn.add(concatArray(arguments.get(), 0));
        return arrayToReturn;
    }

    private List<String> twoArgumentsArray() throws WrongArgumentException {
        List<String> arrayToReturn = new ArrayList<>();
        argumentErrorHandler.checkIfIdIsWrong(arguments.get()[0], taskRepository);
        arrayToReturn.add(arguments.get()[0]);
        arrayToReturn.add(concatArray(arguments.get(), 1));
        return arrayToReturn;
    }

}
