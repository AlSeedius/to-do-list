package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.entities.Task;
import com.alseed.todolist.services.ConsoleWriterService;
import com.alseed.todolist.services.LogWriterService;
import com.alseed.todolist.workers.ArgumentWorker;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Print extends BasicCommand {

    private static String name = "Print";
    private List<String> arguments;

    @Autowired
    public Print(TaskRepository taskRepository, LogWriterService logWriter, ConsoleWriterService consoleWriterService, ArgumentWorker argumentWorker) {
        super(taskRepository, logWriter, consoleWriterService, argumentWorker);
    }

    public void execute() {
        List<Task> taskList = taskRepository.getTaskList();
        if (this.arguments != null) {
            consoleWriterService.printTasksToConsole(taskList.stream());
        } else {
            consoleWriterService.printTasksToConsole(taskList.stream().
                    filter(t -> !t.isCompleted()));
        }
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments =
                    argumentWorker.getResultedArguments(arguments, 1, false);
            if (tempArguments.size() > 0 && tempArguments.get(0).equals("all")) {
                this.arguments = tempArguments;
                return true;
            }
        } else
            return true;
        return false;
    }
}
