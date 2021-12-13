package com.alseed.todolist;

import com.alseed.todolist.entities.WrongArgumentException;
import com.alseed.todolist.interfaces.IArgumentErrorHandler;
import com.alseed.todolist.interfaces.ITaskRepository;

public class ArgumentErrorHandler implements IArgumentErrorHandler {

    public void checkIfIdIsWrong(String argument, ITaskRepository taskRepository) throws WrongArgumentException {
        IDValidator argumentValidator = new IDValidator();
        if (argumentValidator.isValidNumber(argument)) {
            if (!taskRepository.idExists(Integer.parseInt(argument)))
            throw new WrongArgumentException("Не найден указанный идентификатор");
        } else {
            throw new WrongArgumentException("Неверно указаны аргументы к команде");
        }
    }
}
