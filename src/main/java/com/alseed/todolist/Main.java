package com.alseed.todolist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Task> taskList = new ArrayList<>();
    public static void main(String[] args) {

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(in)) {
            String input;
            while ((input = bufferedReader.readLine())!=null) {
                if (input.contains("add "))
                    add(input);
                else if (input.contains("print"))
                    System.out.println(print(input));
                else if (input.contains("toggle"))
                    System.out.println(toggle(input));
                else if (input.equals("quit"))
                    break;
                    else {
                    System.out.println("Указана неверная команда");
                }
            }
        }
        catch (Exception e){
            System.out.println("Указана неверная команда");
        }
    }

    private static void add(String input){
        if (taskList.size()>0)
            taskList.clear();
        taskList.add(new Task(1, input.substring(4), false));
    }

    private static String print(String input){
        String output="";
        try {
            String command;
            if (input.contains("[") && input.contains("]"))
                command = input.substring(input.indexOf("[") + 1, input.indexOf("]"));
            else
                return "Не указаны аргументы для команды.";
            if (command.toLowerCase().equals("all")) {
                for (Task t : taskList)
                    output += printOutputCreator(t);
            } else {
                Task chosenTask;
                if ((chosenTask = findTaskById(Integer.parseInt(command))) != null) {
                    output = printOutputCreator(chosenTask);
                } else output = "Указанная задача не найдена";
            }
        }
        catch (NumberFormatException e){
            output = "Указан неверный аргумент";
        }
        catch (Exception e){
            output = "Необработанное исключение";
        }
        return output;
    }

    private static String getSymbol(boolean toggled){
        if (toggled)
            return "[x] ";
        else
            return "[] ";
    }

    private static String printOutputCreator(Task task){
        return task.getId() + ". " + getSymbol(task.isToggled()) + task.getDescription() + '\n';
    }

    private static Task findTaskById(int id) {
        for (Task t : taskList) {
            if (t.getId() == id)
                return t;
        }
        return null;
    }
    private static String toggle(String input){
        int id;
        Task t;
        try{
            id = Integer.parseInt(input.substring(7));
            if ((t=findTaskById(id))!=null) {
                t.setToggled(!t.isToggled());
                return "";
            }
            else{
                return "Указанный идентификатор не найден в списке";
            }
        }
        catch (NumberFormatException e){
            return "Неверно указан id";
        }
        catch (Exception e){
            return "Необработанное исключение";
        }
    }
}