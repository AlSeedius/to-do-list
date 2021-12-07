package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.TaskRepositoryInterface;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.IOWorker;

import java.util.List;

public class Toggle extends BasicCommand {

    public Toggle(TaskRepositoryInterface taskRepositoryInterface, IOWorker ioWorker) {
        super(taskRepositoryInterface, ioWorker);
    }

    public boolean setArguments(Arguments arguments) {
        try {
            if (arguments != null) {
                List<String> tempArguments = new
                        ArgumentWorker(taskRepositoryInterface, ioWorker).getResultedArguments(arguments, 1, true);
                if (tempArguments.size() > 0) {
                    this.arguments = tempArguments;
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            ioWorker.printAndLogOutput(e);
            return false;
        }
    }

    public void execute(){
        taskRepositoryInterface.toggleTask(Integer.parseInt(arguments.get(0)));
    }

}
