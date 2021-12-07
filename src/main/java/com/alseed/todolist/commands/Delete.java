package com.alseed.todolist.commands;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;
import com.alseed.todolist.businesslayer.ArgumentWorker;
import java.util.List;

public class Delete extends BasicCommand {

    public Delete(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            ArgumentWorker argumentWorker = new ArgumentWorker(taskRepository);
            this.commandOutput = argumentWorker.getMessage();
            List<String> tempArguments = argumentWorker.getResultedArguments(arguments, 1, true);
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }

    public void execute() {
        taskRepository.deleteTask(Integer.parseInt(arguments.get(0)));
    }

}
