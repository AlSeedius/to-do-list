package com.alseed.todolist.businesslayer;
import java.util.regex.Pattern;

public class IDValidator {

    private static IDValidator instance;

    public static IDValidator getInstance(){
        if (instance==null)
            instance = new IDValidator();
        return instance;
    }

    boolean isValidNumber(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        if (line == null)
            return false;
        return pattern.matcher(line).matches();
    }
}
