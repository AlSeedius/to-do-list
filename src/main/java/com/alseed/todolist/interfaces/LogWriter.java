package com.alseed.todolist.interfaces;

import com.alseed.todolist.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface LogWriter {

    default void printWrongArgumentsMessage(){
        System.out.println("Неверно указаны аргументы к команде");
    }

}
