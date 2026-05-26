package pl.pjatk.s36691.gui.zad58.view;

import javax.swing.*;
import java.awt.*;

public class CardButton extends JButton {

    private Image image;

    public CardButton(Image image) {
        this.image = image;

        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    public void setCardImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            return;
        }

        g.drawImage(
                image,
                0,
                0,
                getWidth(),
                getHeight(),
                this
        );
    }
}
