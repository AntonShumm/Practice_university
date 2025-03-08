import service.ServiseConsole;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ServiseConsole serviseConsole = new ServiseConsole();
        try {
            serviseConsole.serviseConcile("src/resources/Tasks.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}