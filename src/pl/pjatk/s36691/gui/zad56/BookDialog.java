package pl.pjatk.s36691.gui.zad56;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class BookDialog extends JDialog {

    private final JTextField authorField;
    private final JTextField titleField;
    private final JTextField priceField;
    private final JTextField coverField;

    private Book book;

    public BookDialog(JFrame parent) {
        super(parent, "Dodaj książkę", true);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        authorField = new JTextField(25);
        titleField = new JTextField(25);
        priceField = new JTextField(25);
        coverField = new JTextField(25);
        coverField.setEditable(false);

        addRow(formPanel, gbc, 0, "Autor:", authorField);
        addRow(formPanel, gbc, 1, "Tytuł:", titleField);
        addRow(formPanel, gbc, 2, "Cena:", priceField);
        addRow(formPanel, gbc, 3, "Okładka:", coverField);

        JPanel buttonPanel = getButtonPanel();

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton buttonAdd = new JButton("Dodaj");
        buttonAdd.addActionListener(_ -> {
            Double price = parsePrice();
            if (price == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Cena musi być liczbą, np. 29,90 albo 29.90",
                        "Niepoprawna cena",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            if (authorField.getText().isBlank()
                    || titleField.getText().isBlank()
                    || coverField.getText().isBlank()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Uzupełnij autora, tytuł i okładkę.",
                        "Brak danych",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            book = new Book(
                    authorField.getText(),
                    titleField.getText(),
                    price,
                    coverField.getText()
            );
            dispose();
        });
        JButton buttonCancel = new JButton("Anuluj");
        buttonCancel.addActionListener(_ -> {
            book = null;
            dispose();
        });
        buttonPanel.add(buttonAdd);
        buttonPanel.add(buttonCancel);
        return buttonPanel;
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int row, String label, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 1;
        panel.add(field, gbc);

        if (row == 3) {
            JButton coverButton = getCoverButton();
            gbc.gridx = 2;
            gbc.gridy = row;
            gbc.weightx = 0;
            panel.add(coverButton, gbc);
        }
    }

    private JButton getCoverButton() {
        JButton coverButton = new JButton("Wybierz");
        coverButton.addActionListener(_ -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(
                    new FileNameExtensionFilter("Obrazki", "jpg", "png", "gif", "jpeg", "bmp", "tif", "tiff", "ico", "webp")
            );
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                coverField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        });
        return coverButton;
    }

    private Double parsePrice() {
        String text = priceField.getText()
                .replace(',', '.')
                .trim();

        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }


    public Book getBook() {
        return book;
    }
}
