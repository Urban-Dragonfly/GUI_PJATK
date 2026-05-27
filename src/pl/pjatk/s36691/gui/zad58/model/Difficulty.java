package pl.pjatk.s36691.gui.zad58.model;

public enum Difficulty {
    EASY(4, 4,  60),
    MEDIUM(6, 6, 3 * 60),
    HARD(8, 8, 5 * 60);

    private final int rows;
    private final int columns;
    private final int seconds;

    Difficulty(int rows, int columns, int seconds) {
        this.rows = rows;
        this.columns = columns;
        this.seconds = seconds;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    public int getSeconds() {
        return seconds;
    }
}
