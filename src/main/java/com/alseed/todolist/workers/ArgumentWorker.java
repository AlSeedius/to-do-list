package com.alseed.todolist.workers;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.commands.Arguments;
import com.alseed.todolist.interfaces.ArgumentValidator;
import com.alseed.todolist.services.ConsoleWriterService;
import com.alseed.todolist.services.LogWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ArgumentWorker implements ArgumentValidator {

    private Arguments arguments;
    private Boolean isFirstArgumentId;
    @Autowired
    ConsoleWriterService consoleWriterService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    LogWriterService logWriter;

    public ArgumentWorker() { }

    public List<String> getResultedArguments(Arguments arguments, Integer numberOfArguments, boolean isFirstArgumentId) {
        this.arguments = arguments;
        this.isFirstArgumentId = isFirstArgumentId;
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
                consoleWriterService.printWrongIdMessage();
                return false;
            }
        } else {
            consoleWriterService.printWrongArgumentsMessage();
            return false;
        }
    }

    private static String concatArray(String[] input, int nStart) {
        return IntStream.range(nStart, input.length)
                .mapToObj((s) -> input[s])
                .collect(Collectors.joining(" "));
    }

}

