package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.ConsoleWriter;
import com.alseed.todolist.workers.IOWorker;
import com.alseed.todolist.workers.LogWriter;

import java.util.List;

public class Delete extends BasicCommand {

    public Delete(TaskRepository taskRepository, IOWorker ioWorker) {
        super(taskRepository, ioWorker);
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments =
                    new ArgumentWorker(arguments, 1, true,
                            taskRepository, ioWorker).getResultedArguments();
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }

    public void execute(){
        taskRepository.deleteTask(Integer.parseInt(arguments.get(0)));
    }

}
