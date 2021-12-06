package com.alseed.todolist.workers;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.commands.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArgumentWorker {
    private final Arguments arguments;
    private final Integer numberOfArguments;
    private final Boolean isFirstArgumentId;
    private final TaskRepository taskRepository;
    private final IOWorker ioWorker;

    public ArgumentWorker(Arguments arguments, Integer numberOfArguments, boolean isFirstArgumentId, TaskRepository taskRepository, IOWorker ioWorker) {
        this.arguments = arguments;
        this.numberOfArguments = numberOfArguments;
        this.isFirstArgumentId = isFirstArgumentId;
        this.taskRepository = taskRepository;
        this.ioWorker = ioWorker;
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
        ArgumentValidator argumentValidator = new ArgumentValidator();
        if (argumentValidator.isValidNumber(argument)) {
            if (taskRepository.idExists(Integer.parseInt(argument))) {
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

