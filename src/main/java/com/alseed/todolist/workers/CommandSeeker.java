package com.alseed.todolist.workers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class CommandSeeker {
    private String fullCommandName;

    @Autowired
    CommandList commandList;

    public CommandSeeker(){
    }

    public boolean commandExists(String seekingName){
        return commandList.getExistingCommands()
                .stream()
                .filter(s -> s.toLowerCase().contains(seekingName.toLowerCase()))
                .map( s -> fullCommandName = s)
                .count()>0;
    }

    public String getFullCommandName() {
        return fullCommandName;
    }
}
