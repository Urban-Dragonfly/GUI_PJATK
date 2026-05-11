package pl.pjatk.s36691.gui.zad49;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
        JButton button = (JButton) e.getSource();
        JTextField countdownField = (JTextField) button.getClientProperty("countdownField");

        long count;

        try {
            count = Long.parseLong(countdownField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a number!");
            return;
        }

        button.setEnabled(false);

        new Thread(() -> {
            long i = count;
            while (i > 0) {
                i--;
                long j = i;
                SwingUtilities.invokeLater(() ->
                    countdownField.setText(String.valueOf(j))
                );
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            SwingUtilities.invokeLater(() ->
                button.setEnabled(true)
            );
        }).start();
    }
}
