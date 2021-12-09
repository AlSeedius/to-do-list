package com.alseed.todolist;

import com.alseed.todolist.commands.BasicCommand;
import com.alseed.todolist.entities.CommandList;
import com.alseed.todolist.entities.WrongArgumentException;
import com.alseed.todolist.interfaces.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleWriter consoleWriter = new ConsoleWriter();
        ICommandList commandList = new CommandList();
        CommandSeeker commandSeeker = new CommandSeeker(commandList);
        ITaskRepository taskRepository = new TaskAsListRepository();
        ICommandFactory commandFactory = new CommandFactory();
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            try {
                ICommandAndArgumentsExtractor extractor = new CommandAndArgumentsExtractor();
                extractor.extractCommandAndArguments(input);
                if (commandSeeker.commandExists(extractor.getCommandName())) {
                    BasicCommand command = commandFactory.createCommand(extractor.getCommandName(), taskRepository);
                    ArgumentSetter argumentSetter = new ArgumentSetter(extractor.getArguments(), taskRepository, command);
                    command.setArguments(argumentSetter.getArgumentList());
                    consoleWriter.writeToConsole(command.execute());
                } else
                    consoleWriter.writeToConsole("Не найдена указанная команда");
            } catch (WrongArgumentException e) {
                consoleWriter.writeToConsole(e.getMessage());
            } catch (Exception e) {
                consoleWriter.writeToConsole("Необработанное исключение");
            }
        }
    }
}