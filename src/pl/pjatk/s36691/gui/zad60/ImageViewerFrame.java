package pl.pjatk.s36691.gui.zad60;

import javax.swing.*;
import java.awt.*;

public class ImageViewerFrame extends JFrame {

    private final Image[] images;
    private final ImagePanel imagePanel;
    private int currentImageIndex = 0;

    public ImageViewerFrame(Image[] images) {
        this.images = images;
        this.imagePanel = new ImagePanel();

        setupFrame();
        addComponents();
        slideshow();

        setVisible(true);
    }

    private void setupFrame() {
        setTitle("Image Viewer");
        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponents() {
        add(imagePanel, BorderLayout.CENTER);
    }

    private void slideshow() {
        Timer timer = new Timer(5000, e -> showNextImage());
        timer.setInitialDelay(0);
        timer.start();
    }

    private void showNextImage() {
        imagePanel.setImage(images[currentImageIndex]);
        if (++currentImageIndex >= images.length) currentImageIndex = 0;
    }
}
