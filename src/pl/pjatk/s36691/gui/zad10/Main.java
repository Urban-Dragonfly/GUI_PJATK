package pl.pjatk.s36691.gui.zad10;

public class Main {

    // naglowek metody potrzebnej do rozpocecia programu

    public static void main(String[] args) {

        // stworzenie instancji obiektu Planeta
        // w bloku zadeklarowano nowa zmienna ktorej nie ma w obiekcie bazowym, oraz dla tego obiektu
        // nadpisano metode toString

        Planet core = new Planet(false, 150000){
            String name = "Earth";
            @Override
            public String toString() {
                return super.toString() + " name " + name;
            }
        };

        //uzyto toString by wyswietlic obiekt w postaci tekstowej na konsoli zgodnie z metoda toString

        System.out.println(core);
    }
}
