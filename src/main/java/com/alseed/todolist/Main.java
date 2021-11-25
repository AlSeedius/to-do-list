package com.alseed.todolist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Task> taskList = new ArrayList<>();
    public static void main(String[] args) {
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(in)) {
            String input;
            while ((input = bufferedReader.readLine())!=null) {
                String[] inputArray = input.split(" ");
                switch (inputArray[0]) {
                    case ("add"):
                        add(inputArray);
                        break;
                    case ("print"):
                        System.out.println(print(inputArray));
                        break;
                    case ("toggle"):
                        System.out.println(toggle(inputArray));
                        break;
                    case ("delete"):
                        System.out.println(delete(inputArray));
                        break;
                    case ("edit"):
                        System.out.println(edit(inputArray));
                        break;
                    case ("search"):
                        System.out.println(search(inputArray));
                        break;
                    default:
                        if (!inputArray[0].equals("quit"))
                            System.out.println("Указана неверная команда");
                        break;
                }
                if (inputArray[0].equals("quit"))
                    break;
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
        StringBuilder stringBuilder = new StringBuilder();
        try {
            if (input.length==1) {
                return taskList.
                        stream()
                        .filter((s) -> !s.isCompleted())
                        .map(Main::printOutputCreator)
                        .collect(Collectors.joining("\n"));
            }
            else if (input[1].toLowerCase().equals("all")) {
                return taskList.
                        stream()
                        .map(Main::printOutputCreator)
                        .collect(Collectors.joining("\n"));
            }
            else output="Указан неверный аргумент для команды";
        }
        catch (NumberFormatException e){
            output = "Указан неверный аргумент";
        }
        catch (Exception e){
            output = "Необработанное исключение";
        }
        return output;
    }

    private static String getSymbol(boolean completed){
        if (completed)
            return "[x] ";
        else
            return "[] ";
    }

    private static String printOutputCreator(Task task){
        return task.getId() + ". " + getSymbol(task.isCompleted()) + task.getDescription();
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
                t.setCompleted(!t.isCompleted());
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
        return taskList.
                stream()
                .filter((s) -> s.getDescription().contains(input[1]))
                .map(Main::printOutputCreator)
                .collect(Collectors.joining("\n"));
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

    private static String concatArray(String[] input, int nStart) {
        StringBuilder output = new StringBuilder();
        for (int i = nStart; i < input.length; i++)
            output.append(input[i] + " ");
        return output.toString().trim();
    }

}