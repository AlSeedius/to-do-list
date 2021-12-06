package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.services.ConsoleWriterService;
import com.alseed.todolist.services.LogWriterService;
import com.alseed.todolist.workers.ArgumentWorker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Quit extends BasicCommand {

    private static String name = "Print";
    private List<String> arguments;

    @Autowired
    public Quit(TaskRepository taskRepository, LogWriterService logWriter, ConsoleWriterService consoleWriterService, ArgumentWorker argumentWorker) {
        super(taskRepository, logWriter, consoleWriterService, argumentWorker);
    }


    public void execute(){
        consoleWriterService.printMessage("Завершение работы программы");
        System.exit(1);
    }

    public boolean setArguments(Arguments arguments) {
        return true;
    }

}
