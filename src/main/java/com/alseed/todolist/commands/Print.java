package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.entities.Task;
import com.alseed.todolist.workers.ArgumentWorker;
import com.alseed.todolist.workers.IOWorker;

import java.util.List;
import java.util.stream.Stream;

public class Print extends BasicCommand {

    public Print(TaskRepository taskRepository, IOWorker ioWorker) {
        super(taskRepository, ioWorker);
    }

    public void execute() {
        Stream<Task> taskStream = taskRepository.getTaskList().stream();
        if (this.arguments == null)
            taskStream = taskStream.filter(t -> !t.isCompleted());
        ioWorker.printAndLogOutput(taskStream);
    }

    public boolean setArguments(Arguments arguments) {
        if (arguments != null) {
            List<String> tempArguments = ArgumentWorker.getInstance(taskRepository, ioWorker).getResultedArguments(arguments,
                            1, false);
            if (tempArguments.size() > 0 && tempArguments.get(0).equals("all")) {
                this.arguments = tempArguments;
                return true;
            } else
                return false;
        } else
            return true;
    }
}
