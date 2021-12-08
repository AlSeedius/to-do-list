package com.alseed.todolist.businesslayer;

import com.alseed.todolist.entities.WrongArgumentException;
import com.alseed.todolist.interfaces.ITaskRepository;

public class ArgumentErrorHandler {

    private static ArgumentErrorHandler instance;

    private ArgumentErrorHandler() {
    }

    public static ArgumentErrorHandler getInstance() {
        if (instance == null)
            instance = new ArgumentErrorHandler();
        return instance;
    }

    void checkIfIdIsWrong(String argument, ITaskRepository taskRepository) throws WrongArgumentException {
        IDValidator argumentValidator = IDValidator.getInstance();
        if (argumentValidator.isValidNumber(argument)) {
            if (!taskRepository.idExists(Integer.parseInt(argument)))
            throw new WrongArgumentException("Не найден указанный идентификатор");
        } else {
            throw new WrongArgumentException("Неверно указаны аргументы к команде");
        }
    }
}
