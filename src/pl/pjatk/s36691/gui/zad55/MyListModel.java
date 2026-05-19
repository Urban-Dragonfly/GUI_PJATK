package pl.pjatk.s36691.gui.zad55;

import javax.swing.*;

public class MyListModel extends AbstractListModel<String> {
    @Override
    public int getSize() {
        return 131;
    }

    @Override
    public String getElementAt(int index) {
        int celsius = -70 + index;
        double fahrenheit = celsius * 1.8 + 32;
        return "%d stopni C = %.1f stopni F".formatted(celsius, fahrenheit);
    }
}
