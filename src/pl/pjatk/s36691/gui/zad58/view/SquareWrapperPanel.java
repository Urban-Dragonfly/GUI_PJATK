package pl.pjatk.s36691.gui.zad58.view;

import javax.swing.*;
import java.awt.*;

public class SquareWrapperPanel extends JPanel {


    public SquareWrapperPanel(Component child) {
        super();
        setLayout(null);
        setBackground(Color.BLACK);
        setOpaque(true);
        add(child);
    }

    @Override
    public void doLayout() {
        if (getComponentCount() == 0) return;

        Component child = getComponent(0);

        int availableWidth = getWidth();
        int availableHeight = getHeight() - 10;

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