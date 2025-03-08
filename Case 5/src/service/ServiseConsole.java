package service;

import concoleWorker.ConcoleWorker;
import concoleWorker.DataProcessor;
import tasks.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiseConsole {

    public void serviseConcile(String path) throws IOException {
        int choice;
        Scanner scanner = new Scanner(System.in);
        DataProcessor dataProcessor = new DataProcessor();
        ConcoleWorker concoleWorker = new ConcoleWorker();

        while (true){

            System.out.println("\n-------------------");
            System.out.println("СПИСОК ДЕЛ");
            System.out.println("-------------------\n");
            System.out.println("1. Добавить задачу.");
            System.out.println("2. Показать полный список задач.");
            System.out.println("3. Получить список выполненых задач.");
            System.out.println("4. Редактировать задачу.");
            System.out.println("5. Удалить задачу.");
            System.out.println("6. Выйти.");
            System.out.print("\nВведите номер и название с большой буквы, чтобы выбрать: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    ArrayList<Task> addTask = dataProcessor.getTask(path);
                    concoleWorker.addTaskList(path, addTask, dataProcessor);
                    break;

                case 2:
                    ArrayList<Task> allTasks = dataProcessor.getTask(path);
                    concoleWorker.listAllTasks(allTasks, dataProcessor);
                    break;

                case 3:
                    ArrayList<Task> clearTasks = dataProcessor.getTask(path);
                    concoleWorker.clearTasks(clearTasks);
                    break;

                case 4:
                    ArrayList<Task> updeteTask = dataProcessor.getTask(path);
                    concoleWorker.updeteTask(path, updeteTask, dataProcessor);
                    break;

                case 5:
                    ArrayList<Task> deleteTasks = dataProcessor.getTask(path);
                    concoleWorker.deleteTask(path, deleteTasks, dataProcessor);
                    break;

                case 6:
                    System.out.println("Программа завершена");
                    return;
            }
        }
    }
}
