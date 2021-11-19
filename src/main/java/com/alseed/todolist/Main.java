package com.alseed.todolist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Task> taskList = new ArrayList<>();
    public static void main(String[] args) {
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(in)) {
            String input;
            while ((input = bufferedReader.readLine())!=null) {
                String[] inputArray = input.split(" ");
                if (inputArray[0].equals("add"))
                    add(inputArray);
                else if (inputArray[0].equals("print"))
                    System.out.println(print(inputArray));
                else if (inputArray[0].equals("toggle"))
                    System.out.println(toggle(inputArray));
                else if (inputArray[0].equals("search"))
                    System.out.println(search(inputArray));
                else if (inputArray[0].equals("delete"))
                    System.out.println(delete(inputArray));
                else if (inputArray[0].equals("edit"))
                    System.out.println(edit(inputArray));
                else if (inputArray[0].equals("quit"))
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

    private static void add(String[] input){
        taskList.add(new Task(getCurrentId(), concatArray(input, 1)));
    }

    private static int getCurrentId() {
        if (taskList.size() == 0)
            return 1;
        else {
            Task maxIdTask = taskList
                    .stream()
                    .max(Comparator.comparing(Task::getId))
                    .orElseThrow(NoSuchElementException::new);
            return maxIdTask.getId()+1;
        }
    }

    private static String print(String[] input){
        String output;
        try {
            String command;
            if (input.length==1) {
                String[] finalOutput = new String[] {""};
                taskList.
                        stream()
                        .filter((s) -> !s.isToggled())
                        .forEach((s) -> finalOutput[0]+=printOutputCreator(s));
                return finalOutput[0];
            }
            else if (input[1].contains("[") && input[1].contains("]"))
                command = input[1].substring(1, input[1].length()-1);
            else
                return "Не указаны аргументы для команды.";
            if (command.toLowerCase().equals("all")) {
                String[] finalOutput = new String[] {""};
                taskList.
                        stream()
                        .forEach((s) -> finalOutput[0]+=printOutputCreator(s));
                return finalOutput[0];
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
    private static String toggle(String[] input){
        int id;
        Task t;
        try{
            id = Integer.parseInt(input[1]);
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

    private static String search(String[] input){
        String searchedString = input[1];
        String[] finalOutput = new String[] {""};
        taskList.
                stream()
                .filter((s) -> s.getDescription().contains(searchedString))
                .forEach((s) -> finalOutput[0]+=printOutputCreator(s));
        return finalOutput[0];
    }

    private static String delete(String[] input){
        try {
            int id = Integer.parseInt(input[1]);
            taskList.removeIf((s) -> s.getId()==id);
            return "";
        }
        catch (NumberFormatException e){
            return "Неверно указан аргумент";
        }
    }

    private static String edit(String[] input){
        try {
            int id = Integer.parseInt(input[1]);
            taskList.stream()
                    .filter(s -> s.getId() == id)
                    .forEach(s -> s.setDescription(concatArray(input, 2)));
            return "";
        }
        catch (NumberFormatException e){
            return "Неверно указан аргумент";
        }
        catch (Exception e){
            return "Необработанное исключение";
        }
    }

    private static String concatArray(String[] input, int nStart){
        String output="";
        for (int i=nStart; i<input.length; i++)
            output+=input[i]+" ";
        return output.trim();
    }

}