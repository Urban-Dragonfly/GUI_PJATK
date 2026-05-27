package pl.pjatk.s36691.gui.zad58.view;

import javax.swing.*;
import java.awt.*;

public class CardPreviewPanel extends JPanel {

    private final Image image;

    public CardPreviewPanel(Image image) {
        this.image = image;
        setOpaque(true);
        setBackground(Color.BLACK);
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

        if (imageWidth <= 0 || imageHeight <= 0) {
            return;
        }

        double scale = Math.min(
                (double) panelWidth / imageWidth,
                (double) panelHeight / imageHeight
        );

        int drawWidth = (int) (imageWidth * scale);
        int drawHeight = (int) (imageHeight * scale);

        int x = (panelWidth - drawWidth) / 2;
        int y = (panelHeight - drawHeight) / 2;

        g.drawImage(image, x, y, drawWidth, drawHeight, this);
    }
}
