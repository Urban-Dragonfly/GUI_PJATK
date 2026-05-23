package pl.pjatk.s36691.gui.zad56;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class PriceCellRenderer extends DefaultTableCellRenderer {

    private final EmptyBorder PADDING = new EmptyBorder(0, 0, 0, 4);
    private final Font CELL_FONT = new Font("Segoe UI", Font.PLAIN, 12);

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column
    ) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setHorizontalAlignment(RIGHT);
        setBorder(PADDING);
        setFont(CELL_FONT);

        if (value instanceof Number number) {
            setText(String.format("%.2f zł", number.doubleValue()));
        } else {
            setText("");
        }

        return this;
    }
}
