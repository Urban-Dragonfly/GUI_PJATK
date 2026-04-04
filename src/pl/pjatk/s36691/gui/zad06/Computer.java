package pl.pjatk.s36691.gui.zad06;

public class Computer {
    private String chip;
    private double memorySize;
    private int id;

    private static int idCounter = 0;

    public Computer(String chip, double memorySize) {
        this.chip = chip;
        this.memorySize = memorySize;
        this.id = ++idCounter;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", type of chip: " + chip
                + ", memory size: " + memorySize + "GB";
    }
}
