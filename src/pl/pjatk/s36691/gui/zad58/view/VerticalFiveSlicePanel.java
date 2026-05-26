package pl.pjatk.s36691.gui.zad58.view;

import javax.swing.*;
import java.awt.*;

public class VerticalFiveSlicePanel extends JPanel {

    private final Image image;

    public VerticalFiveSlicePanel(Image image) {
        this.image = image;
        setOpaque(false);
        setLayout(new BorderLayout());
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

        // Cięcia po osi Y w ORYGINALNYM obrazku.
        int srcTopEnd = 120;
        int srcCenterStart = 360;
        int srcCenterEnd = 670;
        int srcBottomStart = imageHeight - 120;

        int srcTopHeight = srcTopEnd;
        int srcCenterHeight = srcCenterEnd - srcCenterStart;
        int srcBottomHeight = imageHeight - srcBottomStart;

        double scale = (double) panelWidth / imageWidth;

        int destTopHeight = (int) Math.round(srcTopHeight * scale);
        int destCenterHeight = (int) Math.round(srcCenterHeight * scale);
        int destBottomHeight = (int) Math.round(srcBottomHeight * scale);

        int remainingHeight = panelHeight - destTopHeight - destCenterHeight - destBottomHeight;

        if (remainingHeight < 0) {
            g.drawImage(image, 0, 0, panelWidth, panelHeight, this);
            return;
        }

        int destStretchTopHeight = remainingHeight / 2;
        int destStretchBottomHeight = remainingHeight - destStretchTopHeight;

        int y = 0;

        // 1. Góra
        drawPart(g,
                0, y, panelWidth, y + destTopHeight,
                0, 0, imageWidth, srcTopEnd
        );
        y += destTopHeight;

        // 2. Górny stretch
        drawPart(g,
                0, y, panelWidth, y + destStretchTopHeight,
                0, srcTopEnd, imageWidth, srcCenterStart
        );
        y += destStretchTopHeight;

        // 3. Środek
        drawPart(g,
                0, y, panelWidth, y + destCenterHeight,
                0, srcCenterStart, imageWidth, srcCenterEnd
        );
        y += destCenterHeight;

        // 4. Dolny stretch
        drawPart(g,
                0, y, panelWidth, y + destStretchBottomHeight,
                0, srcCenterEnd, imageWidth, srcBottomStart
        );
        y += destStretchBottomHeight;

        // 5. Dół
        drawPart(g,
                0, y, panelWidth, panelHeight,
                0, srcBottomStart, imageWidth, imageHeight
        );
    }

    private void drawPart(Graphics g,
                          int dx1, int dy1, int dx2, int dy2,
                          int sx1, int sy1, int sx2, int sy2) {
        g.drawImage(
                image,
                dx1, dy1, dx2, dy2,
                sx1, sy1, sx2, sy2,
                this
        );
    }
}