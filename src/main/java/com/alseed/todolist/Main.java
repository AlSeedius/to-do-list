package com.alseed.todolist;

import com.alseed.todolist.commands.BasicCommand;
import com.alseed.todolist.services.ConsoleWriterService;
import com.alseed.todolist.services.LogWriterService;
import com.alseed.todolist.workers.CommandAndArgumentsExtractor;
import com.alseed.todolist.workers.CommandFactory;
import com.alseed.todolist.workers.CommandSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private CommandAndArgumentsExtractor commandAndArgumentsExtractor;

    @Autowired
    private CommandSeeker commandSeeker;

    @Autowired
    CommandFactory commandFactory;

    @Autowired
    ConsoleWriterService consoleWriterService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    LogWriterService logWriterService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        logWriterService.setLoggingEnabled(args);
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            commandAndArgumentsExtractor.extractCommandsAndArguments(input);
            if (commandSeeker.commandExists(commandAndArgumentsExtractor.getCommandName())) {
                BasicCommand command = commandFactory.createCommand(commandSeeker.getFullCommandName());
                if (command.setArguments(commandAndArgumentsExtractor.getArgs()))
                    command.execute();
            } else
                consoleWriterService.printWrongCommandMessage();
        }
    }
}