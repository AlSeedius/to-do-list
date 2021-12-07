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

    public void execute(){
        this.commandOutput = TaskStreamToStringConverter.getInstance().taskOutputList(taskRepository.findTask(arguments.get(0)));
    }

}
