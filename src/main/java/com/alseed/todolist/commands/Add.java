package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.IOWorker;

import java.util.List;

public class Add extends BasicCommand {

    public Add(TaskRepository taskRepository, IOWorker ioWorker) {
        super(taskRepository, ioWorker);
    }

    public void execute() {
        taskRepository.addTask(arguments.get(0));
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments =
                    new ArgumentWorker(arguments, 1, false,
                            taskRepository, ioWorker).getResultedArguments();
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }
}
