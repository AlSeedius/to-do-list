package com.alseed.todolist.presentationlayer;

import com.alseed.todolist.businesslayer.MainLogicImplementor;
import com.alseed.todolist.interfaces.*;
import java.io.BufferedReader;

public class ConsoleReaderWorker implements IConsoleReader {

    private final IIOWorker ioWorker;

    public ConsoleReaderWorker(IIOWorker ioWorker){
        this.ioWorker = ioWorker;
    }

    @Override
    public void startReadingConsole(BufferedReader bufferedReader) {
        String input;
        try {
            while ((input = bufferedReader.readLine()) != null) {
                ioWorker.logInput(input);
                IParser parser = new Parser();
                parser.parseCommandAndArguments(input);
                if (commandExists(parser.getParsedCommandName())) {
                    IMainLogicImplementor mainLogicImplementor = new MainLogicImplementor();
                    String commandExecutorMessage = mainLogicImplementor.executeCommand(parser);
                    if (commandExecutorMessage.length() > 0)
                        ioWorker.printAndLogOutput(commandExecutorMessage);
                } else
                    ioWorker.printAndLogOutput("Не найдена указанная команда.");
            }
        }
        catch (Exception e){
            ioWorker.printAndLogOutput(e);
        }
    }

    private boolean commandExists(String commandName) {
        ICommandList commandList = new CommandList();
        return commandList.commandExists(commandName);
    }

}
