package com.alseed.todolist.workers;

import com.alseed.todolist.commands.BasicCommand;
import com.alseed.todolist.interfaces.TaskRepositoryInterface;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainLogicImplementator {

    private IOWorker ioWorker;

    public MainLogicImplementator(IOWorker ioWorker) {
        this.ioWorker = ioWorker;
    }

    public void startWorking(){
        String input;
        TaskRepositoryInterface taskRepository = new TaskAsListRepository();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CommandList commandList = new CommandList();
        try {
            while ((input = bufferedReader.readLine()) != null) {
                ioWorker.logInput(input);
                Parser parser = new Parser();
                parser.ParseCommandAndArguments(input);
                if (commandList.commandExists(parser.getParsedCommandName())){
                    CommandFactory commandFactory = new CommandFactory();
                    BasicCommand command = commandFactory.createCommand(parser.getParsedCommandName(), taskRepository, ioWorker);
                    if (command.setArguments(parser.getParsedCommandArguments()))
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
