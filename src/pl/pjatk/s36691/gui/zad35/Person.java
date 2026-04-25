package pl.pjatk.s36691.gui.zad35;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String pesel;
    private String address;

    public Person(String name, String surname, String pesel, String address) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.address = address;

        int year = Integer.parseInt(pesel.substring(0, 2));
        int month = Integer.parseInt(pesel.substring(2, 4));
        int day = Integer.parseInt(pesel.substring(4, 6));
        int fullYear = year + (month > 12 ? 2000 : 1900);
        if (month > 12) {
            month -= 20;
        }
        this.dateOfBirth = LocalDate.of(fullYear, month, day);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " " + surname + " Data urodzin: " + dateOfBirth + " Adres: " + address;
    }

    public String toTxtFile() {
        return name + ";" + surname + ";" + pesel + ";" + address;
    }
}
