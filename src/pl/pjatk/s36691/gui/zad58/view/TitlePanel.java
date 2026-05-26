package pl.pjatk.s36691.gui.zad58.view;

import java.awt.*;
import javax.swing.*;

public class TitlePanel extends HorizontalFiveSlicePanel {

    private static final Color MAIN_FONT_COLOR = new Color(210, 150, 30);

    public TitlePanel(Image backgroundImage, Font titleFont) {
        super(backgroundImage);

        setPreferredSize(new Dimension(1024, 100));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JLabel titleLabel = new JLabel("MEMORY CATS");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(MAIN_FONT_COLOR);

        add(titleLabel, BorderLayout.CENTER);
    }
}
