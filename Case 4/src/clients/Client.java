package clients;

public class Client {

    String name;
    String surname;
    int year;
    String telephone;
    long score;

    public Client(String name, String surname, int year, String telephone, long score)
    {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.telephone = telephone;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYear() {
        return year;
    }

    public String getTelephone() {
        return telephone;
    }

    public long getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString () {

        return " Имя: " + name + " Фамилия : " + surname + " лет : " + year +
                " телефон : " + telephone + " счёт : " + score + "р";

    }


}


