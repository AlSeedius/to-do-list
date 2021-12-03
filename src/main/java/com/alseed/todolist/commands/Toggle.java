package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.interfaces.ConsoleWriter;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.LogWriter;

import java.util.List;

public class Toggle extends BasicCommand implements ConsoleWriter {

    private static String name = "Toggle";
    private List<String> arguments;

    public Toggle(TaskRepository taskRepository, LogWriter logWriter) {
        super(taskRepository, logWriter);
    }

    public boolean setArguments(Arguments arguments) {
        try {
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
        } catch (Exception e) {
            getLogWriter().logException(e);
            return false;
        }
    }

    public void execute(){
        getTaskRepository().toggleTask(Integer.parseInt(arguments.get(0)));
    }

}
