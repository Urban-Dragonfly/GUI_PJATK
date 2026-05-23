package pl.pjatk.s36691.gui.zad56;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {

        JLabel title = new JLabel("Moja Biblioteka");
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        add(title, BorderLayout.NORTH);

        BookTableModel model = new BookTableModel("src/pl/pjatk/s36691/gui/zad56/books.csv");
        JTable table = new JTable(model);

        table.setRowHeight(200);
        table.getColumnModel().getColumn(0).setCellRenderer(new CoverCellRenderer());
        table.getColumnModel().getColumn(0).setPreferredWidth(140);
        table.getColumnModel().getColumn(0).setMinWidth(140);
        table.getColumnModel().getColumn(0).setMaxWidth(140);
        table.getColumnModel().getColumn(1).setCellRenderer(new TextCellRenderer());
        table.getColumnModel().getColumn(2).setCellRenderer(new TextCellRenderer());
        table.getColumnModel().getColumn(3).setCellRenderer(new PriceCellRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new PriceCellEditor());
        table.getColumnModel().getColumn(3).setPreferredWidth(56);
        table.getColumnModel().getColumn(3).setMinWidth(56);
        table.getColumnModel().getColumn(3).setMaxWidth(56);

        add(new JScrollPane(table));

        JPanel buttonPanel = getButtonPanel(table, model);

        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 750);
        setLocationRelativeTo(null);
        setTitle("Moja Biblioteka");
        setVisible(true);
    }

    private JPanel getButtonPanel(JTable table, BookTableModel model) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton buttonAdd = new JButton("Dodaj Książkę");
        buttonAdd.addActionListener(_ -> {
            int selectedRow = table.getSelectedRow();

            BookDialog dialog = new BookDialog(this);

            if (dialog.getBook() !=null ) {
            model.addBookAt(selectedRow, dialog.getBook());
            }
        });

        JButton buttonRemove = new JButton("Usuń Książkę");
        buttonRemove.addActionListener(_ -> {
            int row = table.getSelectedRow();

            if (row != -1) {
                model.removeBook(row);
            }
        });

        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonRemove);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        return buttonPanel;
    }
}
