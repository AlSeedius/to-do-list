package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.services.ConsoleWriterService;
import com.alseed.todolist.services.LogWriterService;
import com.alseed.todolist.workers.ArgumentWorker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Edit extends BasicCommand {

    private static String name = "Edit";
    private List<String> arguments;

    @Autowired
    public Edit(TaskRepository taskRepository, LogWriterService logWriter, ConsoleWriterService consoleWriterService, ArgumentWorker argumentWorker) {
        super(taskRepository, logWriter, consoleWriterService, argumentWorker);
    }
    public void execute() {
        taskRepository.editTask(Integer.parseInt(arguments.get(0)), arguments.get(1));
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments =
            argumentWorker.getResultedArguments(arguments, 2, true);
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }

}
