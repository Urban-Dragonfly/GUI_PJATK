package pl.pjatk.s36691.gui.zad06;

public class PersonalComputer extends Computer {
    private String username;

    public PersonalComputer(String chip,
                            double memorySize,
                            String username) {
        super(chip, memorySize);
        this.username = username;
    }

    @Override
    public String toString() {
        return super.toString() + ", username: " + username;
    }
}
