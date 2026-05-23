package pl.pjatk.s36691.gui.zad56;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PriceCellEditor extends DefaultCellEditor {

    private final JTextField textField;

    public PriceCellEditor() {
        super(new JTextField());

        textField = (JTextField) getComponent();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textField.setBorder(new EmptyBorder(0,0,0,4));
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column
    ) {
        super.getTableCellEditorComponent(table, value, isSelected, row, column);

        if (value instanceof Number number) {
            textField.setText(String.format("%.2f", number.doubleValue()));
        } else {
            textField.setText("");
        }

        return textField;
    }

    @Override
    public Object getCellEditorValue() {
        String text = textField.getText()
                .replace(',', '.')
                .trim();
        return Double.parseDouble(text);
    }
}
