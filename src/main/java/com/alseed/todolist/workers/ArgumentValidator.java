package com.alseed.todolist.workers;

import java.util.regex.Pattern;

public final class ArgumentValidator {

    public boolean isValidNumber(String string) {
        Pattern pattern = Pattern.compile("\\d+");
        if (string == null)
            return false;
        return pattern.matcher(string).matches();
    }
}
