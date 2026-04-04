package pl.pjatk.s36691.gui.zad26;

public enum Color {
    YELLOW("Żółty", true),
    RED("Czerwony", true),
    BLUE("Niebieski", true),
    ORANGE("Pomarańczowy", false),
    GREEN("Zielony", false),
    PURPLE("Fioletowy", false);

    private final String opis;
    private final boolean base;

    Color(String opis, boolean base) {
        this.opis = opis;
        this.base = base;
    }

    public boolean isBase() {
        return base;
    }

    static Color mixColors(Color a, Color b) {
        if (a == b || ! a.isBase() || ! b.isBase()) {
            throw new IllegalArgumentException();
        }
        return Color.values()[a.ordinal() + b.ordinal() + 2];
    }

    @Override
    public String toString() {
        int num = ordinal() + 1;
        return "(" + num + ") " + this.opis;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (Color color : Color.values()) {
            sb.append(color);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
