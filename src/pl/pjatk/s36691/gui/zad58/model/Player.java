package pl.pjatk.s36691.gui.zad58.model;

public class Player {

    private final String name;
    private int points;
    private int timeLeftSeconds;
    private boolean active;

    public Player(String name, int timeLeftSeconds) {
        this.name = name;
        this.points = 0;
        this.timeLeftSeconds = timeLeftSeconds;
        this.active = true;
    }

    public void addPoint() {
        points++;
    }

    public void decreaseTime() {
        if (timeLeftSeconds > 0) {
            timeLeftSeconds--;
        }

        if (timeLeftSeconds == 0) {
            active = false;
        }
    }

    public boolean canMove() {
        return active && timeLeftSeconds > 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getTimeLeftSeconds() {
        return timeLeftSeconds;
    }

    public boolean isActive() {
        return active;
    }
}
