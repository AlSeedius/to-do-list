package com.alseed.todolist.businesslayer;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.IArgumentValidator;
import com.alseed.todolist.interfaces.ITaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArgumentWorker {

    private ITaskRepository taskRepository;

    private String message;

    public ArgumentWorker(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.message="";
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
        IArgumentValidator argumentValidator = ArgumentValidator.getInstance();
        if (argumentValidator.isValidNumber(argument)) {
            if (taskRepository.idExists(Integer.parseInt(argument))) {
                return true;
            } else {
                this.message = "Не найден указанный идентификатор";
            //    ioWorker.printAndLogOutput("Не найден указанный идентификатор");
                return false;
            }
        } else {
            this.message = "Неверно указаны аргументы к команде";
         //   ioWorker.printAndLogOutput("Неверно указаны аргументы к команде");
            return false;
        }
    }

    private static String concatArray(String[] input, int nStart) {
        return IntStream.range(nStart, input.length)
                .mapToObj((s) -> input[s])
                .collect(Collectors.joining(" "));
    }

    public String getMessage(){
        return this.message;
    }
}

