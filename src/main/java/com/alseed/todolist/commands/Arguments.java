package com.alseed.todolist.commands;

import java.util.Arrays;

public class Arguments {

    private String[] arguments;

    public Arguments(String[] inputArray) {
        this.arguments = Arrays.copyOfRange(inputArray, 1, inputArray.length);
    }

    public String[] getArguments() {
        return arguments;
    }
}