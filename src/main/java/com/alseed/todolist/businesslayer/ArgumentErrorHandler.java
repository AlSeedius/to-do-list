package com.alseed.todolist.businesslayer;

public class ArgumentErrorHandler {
    private String errorMessage;

    public ArgumentErrorHandler(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
