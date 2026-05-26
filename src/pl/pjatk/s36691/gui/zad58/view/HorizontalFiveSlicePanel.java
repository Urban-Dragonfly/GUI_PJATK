package pl.pjatk.s36691.gui.zad58.view;

import javax.swing.*;
import java.awt.*;

public class HorizontalFiveSlicePanel extends JPanel {

    private final Image image;

    public HorizontalFiveSlicePanel(Image image) {
        this.image = image;
        setOpaque(false);
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);
        if (imageWidth <= 0 || imageHeight <= 0) return;

        int srcLeftEnd = 160;
        int srcCenterStart = 430;
        int srcCenterEnd = 594;
        int srcRightStart = 864;

        int srcLeftWidth = srcLeftEnd;
        int srcCenterWidth = srcCenterEnd - srcCenterStart;
        int srcRightWidth = imageWidth - srcRightStart;

        double scale = (double) panelHeight / imageHeight;

        int destLeftWidth = (int) Math.round(srcLeftWidth * scale);
        int destCenterWidth = (int) Math.round(srcCenterWidth * scale);
        int destRightWidth = (int) Math.round(srcRightWidth * scale);

        int remainingWidth = panelWidth - destLeftWidth - destCenterWidth - destRightWidth;

        if (remainingWidth < 0) {
            g.drawImage(image, 0, 0, panelWidth, panelHeight, this);
            return;
        }

        int destStretchLeftWidth = remainingWidth / 2;
        int destStretchRightWidth = remainingWidth - destStretchLeftWidth;

        int x = 0;

        // 1. Lewy ornament
        drawPart(g,
                x, 0, x + destLeftWidth, panelHeight,
                0, 0, srcLeftEnd, imageHeight
        );
        x += destLeftWidth;

        // 2. Lewa belka rozciągana
        drawPart(g,
                x, 0, x + destStretchLeftWidth, panelHeight,
                srcLeftEnd, 0, srcCenterStart, imageHeight
        );
        x += destStretchLeftWidth;

        // 3. Środek
        drawPart(g,
                x, 0, x + destCenterWidth, panelHeight,
                srcCenterStart, 0, srcCenterEnd, imageHeight
        );
        x += destCenterWidth;

        // 4. Prawa belka rozciągana
        drawPart(g,
                x, 0, x + destStretchRightWidth, panelHeight,
                srcCenterEnd, 0, srcRightStart, imageHeight
        );
        x += destStretchRightWidth;

        // 5. Prawy ornament
        drawPart(g,
                x, 0, panelWidth, panelHeight,
                srcRightStart, 0, imageWidth, imageHeight
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
