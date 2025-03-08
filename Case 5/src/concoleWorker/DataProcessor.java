package concoleWorker;

import tasks.Task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataProcessor {

    public ArrayList<Task> getTask(String pathFile) {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String task = parts[0].trim();
                    String stateTask = parts[1].trim();
                    tasks.add(new Task(task, stateTask));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
        return tasks;
    }

    public void recordTask(ArrayList<Task> task, BufferedWriter writer) throws IOException {
        for (Task newTasks : task) {
            writer.write(newTasks.toString());
            writer.newLine();
        }
    }

    public void consoleList(ArrayList<Task> task) {
        int key = 1;
        for (int element = 0; element < task.size(); element++, key++) {
            System.out.print("Номер: " + key + " Задача: ");
            System.out.println(task.get(element));
        }
    }

    public String inputErrorState(String stateTask) {
        Scanner sc = new Scanner(System.in);
        String newStateTask;
        if (stateTask.equals("выполнено") || stateTask.equals("не выполнено")){
            newStateTask = stateTask;
        } else {
           while (true){
                System.out.println("Неправильный ввод, выполнено или не выполнено: ");
                String newState = sc.nextLine();
                if (newState.equals("выполнено") || newState.equals("не выполнено")) {
                    newStateTask = newState;
                    break;
                }
            }
        }
        return newStateTask;
    }

    public int inputErrorElement(int num, ArrayList<Task> tasks){
        Scanner sc = new Scanner(System.in);
        int element;
        if (num <= tasks.size()){
            element = num;
        } else {
            while (true){
                System.out.println("Неправильный номер задачи, введи еще раз: ");
                int newNum = sc.nextInt();
                if (newNum <= tasks.size()) {
                    element = newNum;
                    break;
                }
            }
        }
        return element;
    }

}
