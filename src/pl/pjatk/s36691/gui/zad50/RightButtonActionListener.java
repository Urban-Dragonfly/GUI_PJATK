package pl.pjatk.s36691.gui.zad50;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton rightButton = (JButton) e.getSource();
        JTextField textField = (JTextField) rightButton.getClientProperty("textField");
        JFrame frame = (JFrame) rightButton.getClientProperty("frame");
        frame.setTitle(textField.getText());
    }
}
