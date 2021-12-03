package com.alseed.todolist.workers;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.commands.BasicCommand;
import com.alseed.todolist.interfaces.ConsoleWriter;

import java.io.BufferedReader;

public class Parser implements ConsoleWriter {

    public Parser(BufferedReader br, CommandList commandList, LogWriter logWriter) {
        String input;
        TaskRepository taskRepository = new TaskRepository();
        try {
            while ((input = br.readLine()) != null) {
                logWriter.logInput(input);
                CommandAndArgumentsExtractor extractor = new CommandAndArgumentsExtractor(input);
                CommandSeeker cs = new CommandSeeker(extractor.getCommandName(), commandList);
                if (cs.commandExists()){
                    CommandFactory commandFactory = new CommandFactory(cs.getFullCommandName());
                    BasicCommand command = commandFactory.createCommand(taskRepository, logWriter);
                    if (command.setArguments(extractor.getArgs()))
                        command.execute();
                }
                else{
                    printWrongCommandMessage();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
