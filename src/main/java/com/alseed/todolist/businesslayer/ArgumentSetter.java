package com.alseed.todolist.businesslayer;

import com.alseed.todolist.commands.BasicCommand;
import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.entities.WrongArgumentException;
import com.alseed.todolist.interfaces.ITaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArgumentSetter {

    private static ArgumentSetter instance;

    private ArgumentSetter(){}

    public static ArgumentSetter getInstance(){
        if (instance==null)
            instance = new ArgumentSetter();
        return instance;
    }

    List<String> argumentList(BasicCommand command, Arguments arguments, ITaskRepository taskRepository)
            throws WrongArgumentException {
        List<String> argumentList;
        if ((command.getName().equals("print") || command.getName().equals("quit")) && arguments==null)
            return null;
        else if (command.getNumOfArguments() == 1)
            argumentList = oneArgumentArray(command, arguments, taskRepository);
        else
            argumentList = twoArgumentsArray(arguments, taskRepository);
        return argumentList;
    }

    private static String concatArray(String[] input, int nStart) {
        return IntStream.range(nStart, input.length)
                .mapToObj((s) -> input[s])
                .collect(Collectors.joining(" "));
    }

    private List<String> twoArgumentsArray(Arguments arguments, ITaskRepository taskRepository) throws WrongArgumentException {
        List<String> arrayToReturn = new ArrayList<>();
        ArgumentErrorHandler.getInstance().checkIfIdIsWrong(arguments.getArguments()[0], taskRepository);
        arrayToReturn.add(arguments.getArguments()[0]);
        arrayToReturn.add(concatArray(arguments.getArguments(), 1));
        return arrayToReturn;
    }

    private List<String> oneArgumentArray(BasicCommand command, Arguments arguments, ITaskRepository taskRepository) throws  WrongArgumentException {
        List<String> arrayToReturn = new ArrayList<>();
        if (command.isIdFirstArgument())
            ArgumentErrorHandler.getInstance().checkIfIdIsWrong(arguments.getArguments()[0], taskRepository);
        if (command.getName().equals("print") && !arguments.getArguments()[0].equals("all"))
            throw new WrongArgumentException("Указан неверный аргумент");
        arrayToReturn.add(concatArray(arguments.getArguments(), 0));
        return arrayToReturn;
    }

}
