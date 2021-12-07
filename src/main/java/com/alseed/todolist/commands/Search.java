package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.IOWorker;

import java.util.List;

public class Search extends BasicCommand{

    public Search(TaskRepository taskRepository, IOWorker ioWorker) {
        super(taskRepository, ioWorker);
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments = new
                    ArgumentWorker(taskRepository, ioWorker).getResultedArguments(arguments, 1, false);
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }

    public void execute(){
        ioWorker.printAndLogOutput(taskRepository.findTask(arguments.get(0)));
    }

}
