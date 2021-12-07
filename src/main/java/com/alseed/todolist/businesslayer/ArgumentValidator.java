package com.alseed.todolist.businesslayer;
import java.util.regex.Pattern;

public class ArgumentValidator {

    private static ArgumentValidator instance;

    public static ArgumentValidator getInstance(){
        if (instance==null)
            instance = new ArgumentValidator();
        return instance;
    }

    public boolean isValidNumber(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        if (line == null)
            return false;
        return pattern.matcher(line).matches();
    }
}
