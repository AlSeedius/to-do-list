package com.alseed.todolist.presentationlayer;

import com.alseed.todolist.businesslayer.MainLogicImplementor;
import com.alseed.todolist.entities.CommandExecutorMessage;
import com.alseed.todolist.interfaces.*;

import java.io.BufferedReader;

public class ConsoleReaderWorker implements IConsoleReader {

    private final IIOWorker ioWorker;

    public ConsoleReaderWorker(IIOWorker ioWorker){
        this.ioWorker = ioWorker;
    }

    @Override
    public void startReadingConsole(BufferedReader bufferedReader) throws Exception {
        String input;
        while ((input = bufferedReader.readLine())!=null) {
            ioWorker.logInput(input);
            IParser parser = new Parser();
            parser.ParseCommandAndArguments(input);
            if (commandExists(parser.getParsedCommandName())){
                IMainLogicImplementor mainLogicImplementor = new MainLogicImplementor();
                CommandExecutorMessage taskStreamToStringConverter = mainLogicImplementor.executeCommand(parser);
                if (taskStreamToStringConverter.getMessage().length()>0)
                    ioWorker.printAndLogOutput(taskStreamToStringConverter.getMessage());
            }
            else
                ioWorker.printAndLogOutput("Не найдена указанная команда.");
        }
    }

    private boolean commandExists(String commandName) {
        ICommandList commandList = new CommandList();
        return commandList.commandExists(commandName);
    }

}
