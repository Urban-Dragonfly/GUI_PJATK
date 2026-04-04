package pl.pjatk.s36691.gui.zad28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String[] arr = {
                "office A", "John", "Doe",
                "office B", "John", "Brown",
                "office C", "Mary", "Jones",
                "office B", "Adam", "Rust",
                "office C", "Cindy", "Frost",
                "office A", "Kate", "Coe",
                "office A", "Bill", "Brown"
        };

        Map<String, List<Person>> db = new HashMap<>();

        int i = 0;
        while (i < arr.length) {
            String office = arr[i++];
            String name = arr[i++];
            String surname = arr[i++];
            if (!db.containsKey(office)) {
                db.put(office, new ArrayList<>());
            }
            db.get(office).add(new Person(name, surname));
        }

        String biggestOffice = "";
        int biggest = 0;
        for (Map.Entry<String, List<Person>> entry : db.entrySet()) {
            if (entry.getValue().size() > biggest) {
                biggestOffice = entry.getKey();
                biggest = entry.getValue().size();
            }
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(biggestOffice + ": " + biggest + " users");
    }
}
