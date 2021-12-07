package com.alseed.todolist.commands;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;
import com.alseed.todolist.businesslayer.ArgumentWorker;
import java.util.List;

public class Add extends BasicCommand {

    public Add(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public String execute() {
        if (this.argumentErrorHandler==null) {
            taskRepository.addTask(arguments.get(0));
            return "";
        }
        else
            return argumentErrorHandler.getErrorMessage();
    }

    public void setArguments(Arguments arguments) {
        if (arguments != null) {
            ArgumentWorker argumentWorker = new ArgumentWorker(taskRepository);
            List<String> tempArguments = argumentWorker.getResultedArguments(arguments, 1, false);
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
            }
            if (argumentWorker.getArgumentErrorHandler()!=null)
                this.argumentErrorHandler=argumentWorker.getArgumentErrorHandler();
        }
    }
}
