package error;

public class ErrorGetInformation {

    public void formError(){
        System.out.println("Ошибка заполнения, пожалуйста проверьте: пробелы, знаки препинания, пустые строки");
    }
    public void fileOrDirectory(){

        System.out.println("Файл не найден !!!");
    }

    public void fileNulleble(){

        System.out.println("Ничего не найдено, возможно файл пуст !!!");
    }

}
