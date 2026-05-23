package pl.pjatk.s36691.gui.zad56;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class CoverCellRenderer extends JLabel implements TableCellRenderer {

    private static final int WIDTH = 140;
    private static final int HEIGHT = 200;

    public CoverCellRenderer() {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column
    ) {
        if (value instanceof ImageIcon icon) {
            Image scaledImage = icon.getImage().getScaledInstance(
                    WIDTH,
                    HEIGHT,
                    Image.SCALE_SMOOTH
            );

            setIcon(new ImageIcon(scaledImage));
        } else {
            setText("Brak okładki");
        }

        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getBackground());
        }

        return this;
    }
}
