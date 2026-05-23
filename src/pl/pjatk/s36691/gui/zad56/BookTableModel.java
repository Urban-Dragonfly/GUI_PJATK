package pl.pjatk.s36691.gui.zad56;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BookTableModel extends AbstractTableModel {

    private final List<Book> books = new ArrayList<>();
    private final String[] columnNames = {
            "Okładka", "Autor", "Tytuł", "Cena"
    };

    public BookTableModel(String csvPath) {
        loadBooks(csvPath);
    }

    private void loadBooks(String csvPath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(csvPath));

            for (int i = 1; i < lines.size(); i++) {
                String[] fields = lines.get(i).split(";");

                if (fields.length == 4) {
                    String author = fields[0];
                    String title = fields[1];
                    double price = Double.parseDouble(fields[2]);
                    String cover = "src/pl/pjatk/s36691/gui/zad56/covers/" + fields[3];
                    books.add(new Book(author, title, price, cover));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = books.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> new ImageIcon(book.getCoverFileName());
            case 1 -> book.getAuthor();
            case 2 -> book.getTitle();
            case 3 -> book.getPrice();
            default -> null;
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 3) {
            Book book = books.get(rowIndex);
            book.setPrice((double) aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch(columnIndex) {
            case 0 -> ImageIcon.class;
            case 3 -> Double.class;
            default -> String.class;
        };
    }

    private void addBook(Book book) {
        books.add(book);

        int row = books.size() - 1;
        fireTableRowsInserted(row, row);
    }

    public void addBookAt(int index, Book book) {
        if (index < 0 || index >= books.size()) {
            addBook(book);
            return;
        }

        int insertIndex = index + 1;
        books.add(insertIndex, book);
        fireTableRowsInserted(insertIndex, insertIndex);
    }

    public void removeBook(int index) {
        if (index < 0 || index >= books.size()) return;
        books.remove(index);
        fireTableRowsDeleted (index, index);
    }

}
