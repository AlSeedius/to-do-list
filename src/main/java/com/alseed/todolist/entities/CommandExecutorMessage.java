package com.alseed.todolist.entities;

public class CommandExecutorMessage {

    private String Message;

    private Boolean isSuccessful;

    public CommandExecutorMessage(String message, Boolean isSuccessful) {
        Message = message;
        this.isSuccessful = isSuccessful;
    }

    public String getMessage() {
        return Message;
    }

    public Boolean getSuccessful() {
        return isSuccessful;
    }
}
