package pl.pjatk.s36691.gui.zad58.view;

import javax.swing.*;
import java.awt.*;

public class CardsFoundPanel extends VerticalFiveSlicePanel {

    public CardsFoundPanel(Image backgroundImage, Font buttonFont) {
        super(backgroundImage);

        setPreferredSize(new Dimension(260, 0));
        setMinimumSize(new Dimension(220, 0));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBorder(BorderFactory.createEmptyBorder(40, 28, 40, 28));

        add(Box.createVerticalStrut(20));


        JButton startButton = new JButton("UP");
        startButton.setFont(buttonFont);
        startButton.setAlignmentX(Component.TOP_ALIGNMENT);

        JButton resetButton = new JButton("^");
        resetButton.setFont(buttonFont);
        resetButton.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        add(startButton);
        add(Box.createVerticalStrut(12));
        add(resetButton);
    }
}