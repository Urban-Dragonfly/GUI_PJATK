package pl.pjatk.s36691.gui.zad06;

public class Laptop extends PersonalComputer {
    private double weight;
    public Laptop(String chip,
                  double memorySize,
                  String username,
                  double weight) {
        super(chip, memorySize, username);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", weight: " + weight + "g";
    }

    public void checkWeight() throws Exception {
        if (weight > 5000) {
            throw new Exception("This laptop is not ergonomic - too heavy, over 5000g!");
        } else {
            System.out.println("Weight is " + weight + "g");
        }
    }
}
