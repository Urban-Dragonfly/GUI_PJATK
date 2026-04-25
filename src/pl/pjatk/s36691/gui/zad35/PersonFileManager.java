package pl.pjatk.s36691.gui.zad35;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonFileManager {

    public void saveAsText(List<Person> people) {
        try (PrintWriter writer = new PrintWriter("src/pl/pjatk/s36691/gui/zad35/people.txt")) {
            for (Person person : people) {
                writer.println(person.toTxtFile());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveAsBinary(List<Person> people) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/pl/pjatk/s36691/gui/zad35/people.bin"))) {
            dos.writeInt(people.size());
            for (Person person : people) {
                dos.writeUTF(person.getName());
                dos.writeUTF(person.getSurname());
                dos.writeUTF(person.getPesel());
                dos.writeUTF(person.getAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAsSerialized(List<Person> people) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("src/pl/pjatk/s36691/gui/zad35/people.ser"))) {

            oos.writeObject(people);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> readFromText() {
        List<Person> people = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/pl/pjatk/s36691/gui/zad35/people.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");

                people.add(new Person(parts[0], parts[1], parts[2], parts[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return people;
    }

    public List<Person> readFromBinary() {
        List<Person> people = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream("src/pl/pjatk/s36691/gui/zad35/people.bin"))) {

            int size = dis.readInt();

            for (int i = 0; i < size; i++) {
                String name = dis.readUTF();
                String surname = dis.readUTF();
                String pesel = dis.readUTF();
                String address = dis.readUTF();

                people.add(new Person(name, surname, pesel, address));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return people;
    }

    public List<Person> readFromSerialized() {
        List<Person> people = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("src/pl/pjatk/s36691/gui/zad35/people.ser"))) {

            people = (List<Person>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return people;
    }
}
