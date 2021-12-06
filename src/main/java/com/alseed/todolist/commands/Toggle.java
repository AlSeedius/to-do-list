package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.services.ConsoleWriterService;
import com.alseed.todolist.services.LogWriterService;
import com.alseed.todolist.workers.ArgumentWorker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Toggle extends BasicCommand {

    private static String name = "Toggle";
    private List<String> arguments;

    @Autowired
    public Toggle(TaskRepository taskRepository, LogWriterService logWriter, ConsoleWriterService consoleWriterService, ArgumentWorker argumentWorker) {
        super(taskRepository, logWriter, consoleWriterService, argumentWorker);
    }

    public boolean setArguments(Arguments arguments) {
        try {
            if (arguments != null) {
                List<String> tempArguments =
                        argumentWorker.getResultedArguments(arguments, 1, true);
                if (tempArguments.size() > 0) {
                    this.arguments = tempArguments;
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            logWriter.logException(e);
            return false;
        }
    }

    public void execute() {
        taskRepository.toggleTask(Integer.parseInt(arguments.get(0)));
    }

}
