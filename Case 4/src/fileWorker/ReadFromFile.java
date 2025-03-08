package fileWorker;

import clients.Client;
import error.ErrorGetInformation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFromFile {

    public static List<Client> getClient(String filename) throws FileNotFoundException {
        ErrorGetInformation errorGetInformation = new ErrorGetInformation();
        List<Client> list = new ArrayList<>();
        try (Scanner input = new Scanner(new File(filename))){
            while (input.hasNextLine()) {
                try {
                    String name = input.next();
                    String genre = input.next();
                    int year = input.nextInt();
                    String telephone = input.next();
                    long score = input.nextLong();

                    list.add(new Client(name, genre, year, telephone, score));

                } catch (InputMismatchException e) {
                    errorGetInformation.formError();
                    break;
                } catch (NoSuchElementException e) {
                    errorGetInformation.formError();
                    break;
                }
            }
        }
        return list;
    }
}
