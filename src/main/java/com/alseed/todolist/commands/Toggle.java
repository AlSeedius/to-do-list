package com.alseed.todolist.commands;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;
import com.alseed.todolist.businesslayer.ArgumentWorker;
import java.util.List;

public class Toggle extends BasicCommand {

    public Toggle(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public void setArguments(Arguments arguments) {
        if (arguments != null) {
            ArgumentWorker argumentWorker = new ArgumentWorker(taskRepository);
            List<String> tempArguments = argumentWorker.getResultedArguments(arguments, 1, true);
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
            }
            if (argumentWorker.getArgumentErrorHandler() != null)
                this.argumentErrorHandler = argumentWorker.getArgumentErrorHandler();
        }
    }

    public String execute() {
        if (this.argumentErrorHandler==null) {
            taskRepository.toggleTask(Integer.parseInt(arguments.get(0)));
            return "";
        }
        else
            return argumentErrorHandler.getErrorMessage();
    }
}
