package pl.pjatk.s36691.gui.zad61;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel() {
        setBackground(new Color(20, 60, 80));
        setOpaque(true);
    }

    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        double widthScale = (double) panelWidth / imageWidth;
        double heightScale = (double) panelHeight / imageHeight;
        double scale = Math.min(widthScale, heightScale);

        int scaledWidth = (int) (imageWidth * scale);
        int scaledHeight = (int) (imageHeight * scale);

        int x = (panelWidth - scaledWidth) / 2;
        int y = (panelHeight - scaledHeight) / 2;

        g.drawImage(image, x, y, scaledWidth, scaledHeight, this);
    }
}