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
                ioWorker.printAndLogOutput(MainLogicImplementor.getInstance().commandExecutionOutput(parser));
            }
        }
        catch (Exception e){
            ioWorker.printAndLogOutput(e);
        }
    }


}
