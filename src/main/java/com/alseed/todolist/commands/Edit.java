package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.interfaces.ConsoleWriter;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.LogWriter;

import java.util.List;

public class Edit extends BasicCommand implements ConsoleWriter {

    private static String name = "Edit";
    private List<String> arguments;

    public Edit(TaskRepository taskRepository, LogWriter logWriter) {
        super(taskRepository, logWriter);
    }

    public void execute() {
        getTaskRepository().editTask(Integer.parseInt(arguments.get(0)), arguments.get(1));
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments =
                    new ArgumentWorker(arguments, 2, true,
                            getTaskRepository(), getLogWriter()).getResultedArguments();
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }

}
