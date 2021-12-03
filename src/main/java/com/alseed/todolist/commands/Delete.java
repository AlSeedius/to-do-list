package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.interfaces.ConsoleWriter;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.LogWriter;

import java.util.List;

public class Delete extends BasicCommand implements ConsoleWriter {

    private static String name = "Delete";

    private List<String> arguments;

    public Delete(TaskRepository taskRepository, LogWriter logWriter) {
        super(taskRepository, logWriter);
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments =
                    new ArgumentWorker(arguments, 1, true,
                            getTaskRepository(), getLogWriter()).getResultedArguments();
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }

    public void execute(){
        getTaskRepository().deleteTask(Integer.parseInt(arguments.get(0)));
    }

}
