package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.services.ConsoleWriterService;
import com.alseed.todolist.services.LogWriterService;
import com.alseed.todolist.workers.ArgumentWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Add extends BasicCommand {

    private static String name = "Add";
    private List<String> arguments;

    @Autowired
    public Add(TaskRepository taskRepository, LogWriterService logWriter, ConsoleWriterService consoleWriterService, ArgumentWorker argumentWorker) {
        super(taskRepository, logWriter, consoleWriterService, argumentWorker);
    }

    public void execute() {
        taskRepository.addTask(arguments.get(0));
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments =
                    argumentWorker.getResultedArguments(arguments, 1, false);
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }
}
