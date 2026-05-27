package pl.pjatk.s36691.gui.zad58.view;

import javax.swing.*;
import java.awt.*;

public class CardButton extends JButton {

    private Image image;
    private Image hoverImage;
    private Image pressedImage;

    public CardButton(Image image) {
        this(image, null, null);
    }

    public CardButton(Image image, Image hoverImage, Image pressedImage) {
        this.image = image;
        this.hoverImage = hoverImage;
        this.pressedImage = pressedImage;

        setRolloverEnabled(true);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    public void setCardImage(Image image) {
        this.image = image;
        this.hoverImage = null;
        this.pressedImage = null;
        repaint();
    }

    public void setCardImages(Image image, Image hoverImage, Image pressedImage) {
        this.image = image;
        this.hoverImage = hoverImage;
        this.pressedImage = pressedImage;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Image imageToPaint = image;
        ButtonModel model = getModel();

        if (model.isPressed() && pressedImage != null) {
            imageToPaint = pressedImage;
        } else if (model.isRollover() && hoverImage != null) {
            imageToPaint = hoverImage;
        }

        if (imageToPaint == null) {
            return;
        }

        g.drawImage(
                imageToPaint,
                0,
                0,
                getWidth(),
                getHeight(),
                this
        );
    }
}
