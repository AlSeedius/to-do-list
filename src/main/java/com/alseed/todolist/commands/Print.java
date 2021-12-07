package com.alseed.todolist.commands;

import com.alseed.todolist.businesslayer.TaskStreamToStringConverter;
import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.entities.Task;
import com.alseed.todolist.interfaces.ITaskRepository;
import com.alseed.todolist.businesslayer.ArgumentWorker;

import java.util.List;
import java.util.stream.Stream;

public class Print extends BasicCommand {

    public Print(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public void setArguments(Arguments arguments) {
        if (arguments != null) {
            ArgumentWorker argumentWorker = new ArgumentWorker(taskRepository);
            List<String> tempArguments = argumentWorker.getResultedArguments(arguments,1, false);
            if (tempArguments.size() > 0 && tempArguments.get(0).equals("all")) {
                this.arguments = tempArguments;
            }
            if (argumentWorker.getArgumentErrorHandler() != null)
                this.argumentErrorHandler = argumentWorker.getArgumentErrorHandler();
        }
    }

    public String execute() {
        if (this.argumentErrorHandler==null) {
            Stream<Task> taskStream = taskRepository.getTaskList().stream();
            if (this.arguments == null)
                taskStream = taskStream.filter(t -> !t.isCompleted());
            return TaskStreamToStringConverter.getInstance().taskOutputList(taskStream);
        }
        else
            return argumentErrorHandler.getErrorMessage();
    }
}
