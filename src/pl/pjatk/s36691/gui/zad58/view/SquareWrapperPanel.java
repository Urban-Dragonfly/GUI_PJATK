package pl.pjatk.s36691.gui.zad58.view;

import javax.swing.*;
import java.awt.*;

public class SquareWrapperPanel extends JPanel {

    private final JComponent child;

    public SquareWrapperPanel(JComponent child) {
        super(null);
        this.child = child;
        setBackground(Color.BLACK);
        setOpaque(true);
        add(child);
    }

    @Override
    public void doLayout() {
        int availableWidth = getWidth();
        int availableHeight = getHeight();

        int size = Math.min(availableWidth, availableHeight);

        int x = (availableWidth - size) / 2;
        int y = (availableHeight - size) / 2;

        child.setBounds(x, y, size, size);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(700, 700);
    }
}