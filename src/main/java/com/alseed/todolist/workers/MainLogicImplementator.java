package com.alseed.todolist.workers;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.commands.BasicCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainLogicImplementator {

    private IOWorker ioWorker;

    public MainLogicImplementator(IOWorker ioWorker) {
        this.ioWorker = ioWorker;
    }

    public void startWorking(){
        String input;
        TaskRepository taskRepository = new TaskRepository();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while ((input = bufferedReader.readLine()) != null) {
                ioWorker.logInput(input);
                CommandAndArgumentsExtractor extractor = new CommandAndArgumentsExtractor(input);
                CommandList commandList = new CommandList();
                if (commandList.commandExists(extractor.getCommandName())){
                    CommandFactory commandFactory = new CommandFactory();
                    BasicCommand command = commandFactory.createCommand(extractor.getCommandName(), taskRepository, ioWorker);
                    if (command.setArguments(extractor.getArgs()))
                        command.execute();
                }
                else{
                    ioWorker.printAndLogOutput("Указана неверная команда");
                }
            }
        } catch (Exception e) {
            ioWorker.printAndLogOutput(e);
        }
    }
}
