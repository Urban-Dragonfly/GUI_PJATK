package pl.pjatk.s36691.gui.zad55;

import javax.swing.*;
import java.awt.*;

public class MyListCellRenderer extends JLabel implements ListCellRenderer<String> {
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        setOpaque(true);
        setText(value);

        if (isSelected) {
            setBackground(Color.GREEN.darker());
            setForeground(Color.BLACK);
        } else {
            int celsius = -70 + index;

            if (celsius < 6) {
                setBackground(Color.BLUE.darker());
                setForeground(Color.LIGHT_GRAY);
            } else if (celsius > 25) {
                setBackground(Color.RED.darker());
                setForeground(Color.LIGHT_GRAY);
            } else {
                setBackground(Color.LIGHT_GRAY);
                setForeground(Color.BLACK);
            }
        }

        return this;
    }
}
