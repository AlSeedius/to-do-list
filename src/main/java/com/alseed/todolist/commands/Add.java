package com.alseed.todolist.commands;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;
import com.alseed.todolist.businesslayer.ArgumentWorker;
import java.util.List;

public class Add extends BasicCommand {

    public Add(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public void execute() {
        taskRepository.addTask(arguments.get(0));
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            ArgumentWorker argumentWorker = new ArgumentWorker(taskRepository);
            this.commandOutput = argumentWorker.getMessage();
            List<String> tempArguments = argumentWorker.getResultedArguments(arguments, 1, false);
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }
}
