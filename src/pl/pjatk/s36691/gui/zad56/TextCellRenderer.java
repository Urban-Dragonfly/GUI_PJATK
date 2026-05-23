package pl.pjatk.s36691.gui.zad56;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TextCellRenderer extends JLabel implements TableCellRenderer {

    public TextCellRenderer() {
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setBorder(new EmptyBorder(0, 8, 0, 8));
        setFont(new Font("Segoe UI", Font.BOLD, 14));
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
        String text = value == null ? "" : value.toString();

        int columnWidth = table.getColumnModel().getColumn(column).getWidth() - 16;
        int rowHeight = table.getRowHeight(row);

        setText("""
                <html>
                    <body style='margin:0; padding:0;'>
                        <table width='%d' height='%d'>
                            <tr>
                                <td align='center' valign='middle'>
                                    %s
                                </td>
                            </tr>
                        </table>
                    </body>
                </html>
                """.formatted(columnWidth, rowHeight, text));

        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }

        return this;
    }
}

