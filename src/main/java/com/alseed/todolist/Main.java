package com.alseed.todolist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static List<Task> taskList = new ArrayList<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    static boolean loggingEnabled = false;
    public static void main(String[] args) {
        loggingEnabled = Arrays.stream(args).
                filter(s -> s.equals("log")).
                count()>0;
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(in)) {
            String input;
            while ((input = bufferedReader.readLine())!=null) {
                String[] inputArray = input.split(" ");
                if (loggingEnabled)
                    LOGGER.debug("input: " + input);
                switch (inputArray[0]) {
                    case ("add"):
                        add(inputArray);
                        break;
                    case ("print"):
                        printAndLogDebug(print(inputArray));
                        break;
                    case ("toggle"):
                        printAndLogDebug(toggle(inputArray));
                        break;
                    case ("delete"):
                        printAndLogDebug(delete(inputArray));
                        break;
                    case ("edit"):
                        printAndLogDebug(edit(inputArray));
                        break;
                    case ("search"):
                        printAndLogDebug(search(inputArray));
                        break;
                    default:
                        if (!inputArray[0].equals("quit"))
                            printAndLogDebug("Указана неверная команда");
                        break;
                }
                if (inputArray[0].equals("quit")) {
                    LOGGER.debug("Завершение работы приложения");
                    break;
                }
            }
        }
        catch (Exception e){
            printAndLogError("Необработанное исключение", e);
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
            output = printAndLogError("Указан неверный аргумент", e);
        }
        catch (Exception e){
            output = printAndLogError("Необработанное исключение", e);
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
            return printAndLogError("Неверно указан id", e);
        }
        catch (Exception e){
            return printAndLogError("Необработанное исключение", e);
        }
    }

    private static String search(String[] input) {
        String output = taskList.
                stream()
                .filter((s) -> s.getDescription().contains(input[1]))
                .map(Main::printOutputCreator)
                .collect(Collectors.joining("\n"));
        if (output.length()<0)
            return output;
        else
            return "Ничего не найдено";
    }

    private static String delete(String[] input){
        try {
            int id = Integer.parseInt(input[1]);
            taskList.removeIf((s) -> s.getId()==id);
            return "";
        }
        catch (NumberFormatException e){
            return printAndLogError("Неверно указан аргумент", e);
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
            return printAndLogError("Неверно указан аргумент", e);
        }
        catch (Exception e){
            return printAndLogError("Необработанное исключение", e);
        }
    }

    private static String concatArray(String[] input, int nStart) {
        return IntStream.range(nStart, input.length)
                .mapToObj((s) -> input[s])
                .collect(Collectors.joining(" "));
    }

    private static void printAndLogDebug(String printLine) {
        if (printLine.length() > 0 && loggingEnabled)
            LOGGER.debug("output: " + printLine);
        System.out.println(printLine);
    }

    private static String printAndLogError(String printLine, Exception e){
        LOGGER.error(e.toString());
        return printLine;
    }

}