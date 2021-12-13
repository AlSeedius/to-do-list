package com.alseed.todolist.entities;

public class CommandInfo {
    private String name;
    private Integer numberOfArguments;
    private Boolean isIdFirstArgument;

    public CommandInfo(String name, Integer numberOfArguments, Boolean isIdFirstArgument) {
        this.name = name;
        this.numberOfArguments = numberOfArguments;
        this.isIdFirstArgument = isIdFirstArgument;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfArguments() {
        return numberOfArguments;
    }

    public Boolean getIdFirstArgument() {
        return isIdFirstArgument;
    }
}
