package com.alseed.todolist.interfaces;

import com.alseed.todolist.entities.WrongArgumentException;

public interface IArgumentErrorHandler {
    void checkIfIdIsWrong(String argument, ITaskRepository taskRepository) throws WrongArgumentException;
}
