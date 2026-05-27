package pl.pjatk.s36691.gui.zad58.view;

import java.awt.*;
import javax.swing.*;

public class TitlePanel extends HorizontalFiveSlicePanel {

    private static final Color MAIN_FONT_COLOR = new Color(210, 150, 30);
    private final JLabel titleLabel;

    public TitlePanel(Image backgroundImage, Font titleFont) {
        super(backgroundImage);

        setPreferredSize(new Dimension(1024, 100));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        titleLabel = new JLabel("MEMORY CATS");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(MAIN_FONT_COLOR);

        add(titleLabel, BorderLayout.CENTER);
    }

    public void resetTitle() {
        titleLabel.setText("MEMORY CATS");
    }

    public void showGameOverTitle() {
        titleLabel.setText("GAME OVER");
    }

    public void showYouWonTitle() {
        titleLabel.setText("YOU WON!");
    }

    public void showPlayerOneWonTitle() {
        titleLabel.setText("PLAYER 1 WON!");
    }

    public void showPlayerTwoWonTitle() {
        titleLabel.setText("PLAYER 2 WON!");
    }

    public void showTieTitle() {
        titleLabel.setText("IT'S A TIE!");
    }
}
