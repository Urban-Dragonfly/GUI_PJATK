package pl.pjatk.s36691.gui.zad10;

public class Planet {

    // zmienne klasy planet
    // moglyby byc private, nie sa zmieniane wiec rowniez final

    boolean isGas;
    long distanceFromSun;

    //konstruktor, uzywa obu wczesniej zadeklarowanych zmiennych

    public Planet(boolean isGas, long distanceFromSun){
        this.isGas = isGas;
        this.distanceFromSun = distanceFromSun;
    }

    //metoda toString do zmiany opisu tekstowego obiektu
    //przydalby sie naglowek @Override
    //uzyte zmienne nie potrzebuja this. bo jest to domyslne

    public String toString(){
        return "isGas: " + isGas + " distance " + distanceFromSun;
    }
}
