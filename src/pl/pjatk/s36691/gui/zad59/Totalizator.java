package pl.pjatk.s36691.gui.zad59;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Totalizator extends JFrame {

    private final CouponsGenerator generator;
    private final JTable couponTable;
    private final JLabel titleLabel;
    private final JButton generateButton;

    public Totalizator() {
        this.generator = new CouponsGenerator(6, 6, 49);
        this.couponTable = new JTable();
        this.titleLabel = new JLabel();
        this.generateButton = new JButton();

        setupFrame();
        setupTitleLabel();
        setupCouponTable();
        setupGenerateButton();

        addComponents();

        setVisible(true);

    }

    private void setupFrame() {
        setTitle("Totalizator Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 462);
        setLocationRelativeTo(null);
    }

    private void setupTitleLabel() {
        titleLabel.setText("T O T A L I Z A T O R   G E N E R A T O R");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Poor Richard", Font.BOLD, 36));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.YELLOW.darker());
        titleLabel.setForeground(Color.BLUE.darker());
    }

    private void setupCouponTable() {
        couponTable.setModel(createTableModel(generator.getCoupons()));
        couponTable.setFont(new Font("Consolas", Font.BOLD, 18));
        couponTable.setRowHeight(couponTable.getRowHeight() + 20);
        couponTable.setShowGrid(true);
        couponTable.setGridColor(Color.BLACK);
        couponTable.setIntercellSpacing(new Dimension(20, 0));
        couponTable.setOpaque(true);
        couponTable.setBackground(Color.WHITE.darker());
        couponTable.setForeground(Color.BLACK);
        couponTable.setRowSelectionAllowed(false);
        couponTable.setColumnSelectionAllowed(false);
    }

    private void setupGenerateButton() {
        generateButton.setText("Generuj nowe kupony");
        generateButton.setBackground(Color.BLUE.darker());
        generateButton.setForeground(Color.YELLOW.darker());
        generateButton.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        generateButton.setOpaque(true);
        generateButton.setFont(new Font("Poor Richard", Font.BOLD, 24));
        generateButton.addActionListener(e -> {
            generator.generateCoupons();
            couponTable.setModel(createTableModel(generator.getCoupons()));
        });
    }

    private void addComponents() {
        add(titleLabel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(couponTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        scrollPane.getViewport().setBackground(Color.WHITE.darker());
        scrollPane.getViewport().setOpaque(true);
        scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(scrollPane, BorderLayout.CENTER);
        add(generateButton, BorderLayout.SOUTH);
    }

    private DefaultTableModel createTableModel(int[][] coupons) {
        String[] columnNames = {
          "Liczba 1", "Liczba 2", "Liczba 3", "Liczba 4", "Liczba 5", "Liczba 6"
        };

        Object[][] data = new Object[coupons.length][coupons[0].length];

        for (int row = 0; row < coupons.length; row++) {
            for (int col = 0; col < coupons[row].length; col++) {
                data[row][col] = coupons[row][col];
            }
        }

        return new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }

        };
    }
}
