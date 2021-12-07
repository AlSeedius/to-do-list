package com.alseed.todolist.workers;

import java.util.regex.Pattern;

public class ArgumentValidator {

    private static ArgumentValidator instance;

    public static ArgumentValidator getInstance(){
        if (instance==null)
            instance = new ArgumentValidator();
        return instance;
    }

    public boolean isValidNumber(String string) {
        Pattern pattern = Pattern.compile("\\d+");
        if (string == null)
            return false;
        return pattern.matcher(string).matches();
    }
}
