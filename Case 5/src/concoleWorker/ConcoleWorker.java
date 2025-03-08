package concoleWorker;

import tasks.Task;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ConcoleWorker {

    public void addTaskList(String path, ArrayList<Task> addTask, DataProcessor dataProcessor) {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            System.out.println("Задача:");
            String task = scanner.nextLine();

            System.out.println("Статус задачи:");
            System.out.println("Обращаем ваше внимание,что для корректной работы приложения, текст должен быть написан без ошибок: " +
                    "\"выполнено\" или \"не выполнено\"");
            String stateTask = scanner.nextLine();
            stateTask = dataProcessor.inputErrorState(stateTask);

            addTask.add(new Task(task, stateTask));
            dataProcessor.recordTask(addTask, writer);
            System.out.println("Задача записана");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    public void listAllTasks(ArrayList<Task> allTasks, DataProcessor dataProcessor) {
        System.out.println("Полный список задач:");
        dataProcessor.consoleList(allTasks);
    }

    public void clearTasks(ArrayList<Task> clearTasks) {
        System.out.println("Список выполненных задач:");
        clearTasks.stream()
                .filter(stateTask -> stateTask.getStateTask().equals("выполнено"))
                .forEach(System.out::println);
    }

    public void updeteTask(String path, ArrayList<Task> updeteTasks, DataProcessor dataProcessor) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            System.out.println("Номер какой задачи вы хотите редактировать? ");
            dataProcessor.consoleList(updeteTasks);

            System.out.println("Укажите номер: ");
            int num = scanner.nextInt();
            num = dataProcessor.inputErrorElement(num,updeteTasks);
            int numCorrect = --num;
            scanner.nextLine();

            System.out.println("Редактирование задачи: ");
            String task = scanner.nextLine();

            System.out.println("Редактирование статуса: ");
            System.out.println("Обращаем ваше внимание, что для корректной работы приложения, текст должен быть написан без ошибок: " +
                    "\"выполнено\" или \"не выполнено\"");
            String stateTask = scanner.nextLine();
            stateTask = dataProcessor.inputErrorState(stateTask);

            Task adUpdateTask = new Task(task, stateTask);
            updeteTasks.set(numCorrect, adUpdateTask);
            int numCorrectUP = ++num;
            System.out.println("Задача номер: " + numCorrectUP + " редактирована ");
            dataProcessor.recordTask(updeteTasks, writer);

        }
    }

    public void deleteTask(String path, ArrayList<Task> deleteTasks, DataProcessor dataProcessor) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            System.out.println("Какую задачу вы хотите удалить? ");
            dataProcessor.consoleList(deleteTasks);

            System.out.println("Укажите номер: ");
            int num = scanner.nextInt();
            num = dataProcessor.inputErrorElement(num,deleteTasks);
            int numCorrect = --num;

            deleteTasks.remove(numCorrect);

            int numCorrectUP = ++num;
            System.out.println("Задача номер: " + numCorrectUP + " удалена");
            dataProcessor.recordTask(deleteTasks, writer);
        }
    }
}
