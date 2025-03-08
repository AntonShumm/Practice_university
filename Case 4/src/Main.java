import clients.Client;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import fileWorker.ReadFromFile;
import error.ErrorGetInformation;


public class Main {

    public static void main(String[] args) {
        ErrorGetInformation errorGetInformation = new ErrorGetInformation();
        try {
            List<Client> resurtList = ReadFromFile.getClient("src/resources/Clients.txt");
            if (resurtList == null) {
                errorGetInformation.fileNulleble();
                return;
            }
            System.out.println("Сортировка по самым богатым клиентам: ");
            resurtList.stream()
                    .sorted(Comparator.comparingLong(Client :: getScore).reversed())
                    .forEach(System.out::println);
        } catch (FileNotFoundException e) {
            errorGetInformation.fileOrDirectory();
        }
    }
}