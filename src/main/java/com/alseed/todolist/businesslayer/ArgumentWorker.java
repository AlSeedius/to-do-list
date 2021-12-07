package com.alseed.todolist.businesslayer;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArgumentWorker {

    private ITaskRepository taskRepository;

    private ArgumentErrorHandler argumentErrorHandler;

    public ArgumentWorker(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ArgumentErrorHandler getArgumentErrorHandler() {
        return argumentErrorHandler;
    }

    public List<String> getResultedArguments(Arguments arguments, Integer numberOfArguments, Boolean isFirstArgumentId) {
        List<String> resultedArguments = new ArrayList<>();
        if (numberOfArguments == 1) {
            saveIdAsArgument(concatArray(arguments.getArguments(), 0), resultedArguments, arguments, isFirstArgumentId);
        } else if (numberOfArguments == 2) {
            saveIdAsArgument(arguments.getArguments()[0], resultedArguments, arguments,  isFirstArgumentId);
        }
        return resultedArguments;
    }

    private void saveIdAsArgument(String argumentToReturn, List<String> resultedArguments,
                                  Arguments arguments, Boolean isFirstArgumentId) {
        if (!isFirstArgumentId || checkIdArgument(argumentToReturn)) {
                resultedArguments.add(argumentToReturn);
                resultedArguments.add(concatArray(arguments.getArguments(), 1));
        }
    }

    private boolean checkIdArgument(String argument) {
        ArgumentValidator argumentValidator = ArgumentValidator.getInstance();
        if (argumentValidator.isValidNumber(argument)) {
            if (taskRepository.idExists(Integer.parseInt(argument))) {
                return true;
            } else {
                this.argumentErrorHandler = new ArgumentErrorHandler("Не найден указанный идентификатор");
                return false;
            }
        } else {
            this.argumentErrorHandler = new ArgumentErrorHandler("Неверно указаны аргументы к команде");
            return false;
        }
    }

    private static String concatArray(String[] input, int nStart) {
        return IntStream.range(nStart, input.length)
                .mapToObj((s) -> input[s])
                .collect(Collectors.joining(" "));
    }
}

