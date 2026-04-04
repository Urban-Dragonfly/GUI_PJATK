package pl.pjatk.s36691.gui.zad11;

public class Main {
    public static void main(String[] args) {
        Figura[] figury = {
                new Prostokat("czerwony", 2, 3),
                new Kwadrat("niebieski", 5),
                new Trojkat("zielony", 17, 5),
        };

        for (Figura figura : figury) {
            System.out.println(figura);
        }
    }
}
