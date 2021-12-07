package com.alseed.todolist.presentationlayer;
import com.alseed.todolist.interfaces.ICommandList;
import java.util.*;

public class CommandList implements ICommandList {

    private List<String> existingCommands;

    public CommandList(){
        existingCommands = new ArrayList<> (
            Arrays.asList("print", "add", "delete", "edit", "quit", "search", "toggle"));
    }

    @Override
    public boolean commandExists(String seekingName){
        return existingCommands
                .stream()
                .anyMatch(s -> s.toLowerCase().contains(seekingName.toLowerCase()));
    }
}
