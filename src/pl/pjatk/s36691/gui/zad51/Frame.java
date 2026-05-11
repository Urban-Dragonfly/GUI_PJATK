package pl.pjatk.s36691.gui.zad51;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Frame extends JFrame {
    public Frame() {

        setTitle("WORDS");

        JTextArea textArea = new JTextArea(8,64);
        textArea.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(8,8,0,8));
        textPanel.add(textArea);
        add(textPanel, BorderLayout.CENTER);

        JPanel menu = new JPanel();
        menu.setLayout(new FlowLayout(FlowLayout.CENTER, 16, 8));

        JButton backButton = new JButton("Back");
        backButton.setEnabled(false);
        JButton showWords = new JButton("Show words");

        backButton.addActionListener((_) -> {
            String originalText = (String) backButton.getClientProperty("words");
            if (originalText != null) {
                textArea.setText(originalText);
                showWords.setEnabled(true);
                backButton.setEnabled(false);
            }
        });


        showWords.addActionListener((_) -> {
            String text = textArea.getText();
            backButton.putClientProperty("words", text);

            if (text.trim().isEmpty()) return;

            String[] words = text.trim().split("\\s+");
            StringBuilder sb = new StringBuilder();

            Arrays.stream(words)
                    .map(String::toLowerCase)
                    .distinct()
                    .forEach(word -> sb.append(word).append("\n"));

            textArea.setText(sb.toString());
            backButton.setEnabled(true);
            showWords.setEnabled(false);
        });

        menu.add(backButton);
        menu.add(showWords);
        add(menu, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
