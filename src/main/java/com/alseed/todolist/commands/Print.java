package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.entities.Task;
import com.alseed.todolist.interfaces.ConsoleWriter;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.LogWriter;

import java.util.List;

public class Print extends BasicCommand implements ConsoleWriter {

    private static String name = "Print";
    private List<String> arguments;

    public Print(TaskRepository taskRepository, LogWriter logWriter) {
        super(taskRepository, logWriter);
    }

    public void execute() {
        List<Task> taskList = getTaskRepository().getTaskList();
        if (this.arguments!=null){
            printTasksToConsole(taskList.stream());
        }
        else{
            printTasksToConsole(taskList.stream().
                    filter(t -> !t.isCompleted()));
        }
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments =
                    new ArgumentWorker(arguments, 1, false,
                            getTaskRepository(), getLogWriter()).getResultedArguments();
            if (tempArguments.size() > 0 && tempArguments.get(0).equals("all")) {
                this.arguments = tempArguments;
                return true;
            }
        }
        else
            return true;
        return false;
    }
}
