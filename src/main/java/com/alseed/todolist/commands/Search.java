package com.alseed.todolist.commands;

import com.alseed.todolist.businesslayer.TaskStreamToStringConverter;
import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;
import com.alseed.todolist.businesslayer.ArgumentWorker;
import java.util.List;

public class Search extends BasicCommand{

    public Search(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public void setArguments(Arguments arguments) {
        if (arguments != null) {
            ArgumentWorker argumentWorker = new ArgumentWorker(taskRepository);
            List<String> tempArguments = argumentWorker.getResultedArguments(arguments,1, false);
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
            }
            if (argumentWorker.getArgumentErrorHandler() != null)
                this.argumentErrorHandler = argumentWorker.getArgumentErrorHandler();
        }
    }

    public String execute() {
        if (this.argumentErrorHandler==null) {
            taskRepository.addTask(arguments.get(0));
            return TaskStreamToStringConverter.getInstance().taskOutputList(taskRepository.findTask(arguments.get(0)));
        }
        else
            return argumentErrorHandler.getErrorMessage();
    }

}
