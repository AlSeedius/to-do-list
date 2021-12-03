package com.alseed.todolist.workers;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.commands.Arguments;
import com.alseed.todolist.interfaces.ArgumentValidator;
import com.alseed.todolist.interfaces.ConsoleWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArgumentWorker implements ArgumentValidator, ConsoleWriter {
    private Arguments arguments;
    private Integer numberOfArguments;
    private Boolean isFirstArgumentId;
    private TaskRepository taskRepository;
    private LogWriter logWriter;

    public ArgumentWorker(Arguments arguments, Integer numberOfArguments, boolean isFirstArgumentId, TaskRepository taskRepository, LogWriter logWriter) {
        this.arguments = arguments;
        this.numberOfArguments = numberOfArguments;
        this.isFirstArgumentId = isFirstArgumentId;
        this.taskRepository = taskRepository;
        this.logWriter = logWriter;
    }

    public List<String> getResultedArguments() {
        List<String> resultedArguments = new ArrayList<>();
        if (numberOfArguments == 1) {
            saveIdAsArgument(concatArray(arguments.getArguments(), 0), resultedArguments);
        } else if (numberOfArguments == 2) {
            saveIdAsArgument(arguments.getArguments()[0], resultedArguments);
        }
        return resultedArguments;
    }

    private void saveIdAsArgument(String argumentToReturn, List<String> resultedArguments) {
        if (isFirstArgumentId) {
            if (checkIdArgument(argumentToReturn)) {
                resultedArguments.add(argumentToReturn);
                resultedArguments.add(concatArray(arguments.getArguments(), 1));
            }
        } else {
            resultedArguments.add(argumentToReturn);
            resultedArguments.add(concatArray(arguments.getArguments(), 1));
        }
    }

    private boolean checkIdArgument(String argument) {
        if (isValidNumber(argument)) {
            if (taskRepository.idExists(Integer.parseInt(argument))) {
                return true;
            } else {
                printWrongIdMessage();
                return false;
            }
        } else {
            printWrongArgumentsMessage();
            return false;
        }
    }

    private static String concatArray(String[] input, int nStart) {
        return IntStream.range(nStart, input.length)
                .mapToObj((s) -> input[s])
                .collect(Collectors.joining(" "));
    }

}

