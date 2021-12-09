package com.alseed.todolist.entities;

public class WrongArgumentException extends Exception {
    public WrongArgumentException(String errorMessage){
        super(errorMessage);
    }
}