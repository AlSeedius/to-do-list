package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.TaskRepositoryInterface;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.IOWorker;

import java.util.List;

public class Edit extends BasicCommand{


    public Edit(TaskRepositoryInterface taskRepositoryInterface, IOWorker ioWorker) {
        super(taskRepositoryInterface, ioWorker);
    }

    public void execute() {
        taskRepositoryInterface.editTask(Integer.parseInt(arguments.get(0)), arguments.get(1));
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments = new
                    ArgumentWorker(taskRepositoryInterface, ioWorker).getResultedArguments(arguments, 2, true);
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }

}
