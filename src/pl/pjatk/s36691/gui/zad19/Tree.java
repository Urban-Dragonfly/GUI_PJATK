package pl.pjatk.s36691.gui.zad19;

import java.util.Comparator;

public class Tree implements Comparable<Tree> {

    private String name;
    private int height;
    private int age;

    public Tree(String name, int height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    //Getters:
    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    //Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Nazwa Drzewa: " + name + " | Wiek (lata): " + age + " | Wysokość: " + height +"m.";
    }

    @Override
    public int compareTo(Tree o) {
        return Integer.compare(this.age, o.age);
    }
}
