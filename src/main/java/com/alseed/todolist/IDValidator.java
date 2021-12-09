package com.alseed.todolist;
import java.util.regex.Pattern;

public class IDValidator {

    public boolean isValidNumber(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        if (line == null)
            return false;
        return pattern.matcher(line).matches();
    }
}
