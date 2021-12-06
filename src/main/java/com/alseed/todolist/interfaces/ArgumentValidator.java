package com.alseed.todolist.interfaces;

import com.alseed.todolist.TaskRepository;

import java.util.regex.Pattern;

public interface ArgumentValidator {

    default boolean isValidNumber(String string) {
        Pattern pattern = Pattern.compile("\\d+");
        if (string == null)
            return false;
        return pattern.matcher(string).matches();
    }

    default boolean oneArgumentOk(String argument){
        return isValidNumber(argument);
    }
}
