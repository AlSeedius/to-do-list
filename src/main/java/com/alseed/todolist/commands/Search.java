package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.interfaces.ConsoleWriter;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.LogWriter;

import java.util.List;

public class Search extends BasicCommand implements ConsoleWriter {

    private static String name = "Search";
    private List<String> arguments;

    public Search(TaskRepository taskRepository, LogWriter logWriter) {
        super(taskRepository, logWriter);
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments =
                    new ArgumentWorker(arguments, 1, false,
                            getTaskRepository(), getLogWriter()).getResultedArguments();
            if (tempArguments.size() > 0) {
                this.arguments = tempArguments;
                return true;
            }
        }
        return false;
    }

    public void execute(){
        printTasksToConsole(getTaskRepository().findTask(arguments.get(0)));
    }

}
