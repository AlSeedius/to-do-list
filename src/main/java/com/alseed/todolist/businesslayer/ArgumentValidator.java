package com.alseed.todolist.businesslayer;
import com.alseed.todolist.interfaces.IArgumentValidator;
import java.util.regex.Pattern;

public class ArgumentValidator implements IArgumentValidator {

    private static ArgumentValidator instance;

    public static ArgumentValidator getInstance(){
        if (instance==null)
            instance = new ArgumentValidator();
        return instance;
    }

    @Override
    public boolean isValidNumber(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        if (line == null)
            return false;
        return pattern.matcher(line).matches();
    }
}
