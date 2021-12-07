package com.alseed.todolist.workers;

import com.alseed.todolist.commands.Arguments;
import com.alseed.todolist.interfaces.TaskRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArgumentWorker {

    private TaskRepositoryInterface taskRepositoryInterface;
    private IOWorker ioWorker;


    public ArgumentWorker(TaskRepositoryInterface taskRepositoryInterface, IOWorker ioWorker) {
        this.taskRepositoryInterface = taskRepositoryInterface;
        this.ioWorker = ioWorker;
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
        if (ArgumentValidator.getInstance().isValidNumber(argument)) {
            if (taskRepositoryInterface.idExists(Integer.parseInt(argument))) {
                return true;
            } else {
                ioWorker.printAndLogOutput("Не найден указанный идентификатор");
                return false;
            }
        } else {
            ioWorker.printAndLogOutput("Неверно указаны аргументы к команде");
            return false;
        }
    }

    private static String concatArray(String[] input, int nStart) {
        return IntStream.range(nStart, input.length)
                .mapToObj((s) -> input[s])
                .collect(Collectors.joining(" "));
    }

}

