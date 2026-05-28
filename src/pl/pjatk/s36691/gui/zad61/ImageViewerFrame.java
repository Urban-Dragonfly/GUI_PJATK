package pl.pjatk.s36691.gui.zad61;

import javax.swing.*;
import java.awt.*;

public class ImageViewerFrame extends JFrame {

    private final Image[] images;
    private final ImagePanel imagePanel;
    private final ThumbnailList thumbnailList;
    private Timer timer;

    private int currentImageIndex = 0;

    public ImageViewerFrame(Image[] images) {
        this.images = images;
        this.imagePanel = new ImagePanel();
        this.thumbnailList = new ThumbnailList(images);
        this.timer = null;

        setupFrame();
        addComponents();
        setupListener();
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
        add(thumbnailList, BorderLayout.NORTH);

        JPanel imagePanelWrapper = new JPanel(new BorderLayout());
        imagePanelWrapper.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        imagePanelWrapper.setBackground(new Color(20, 60, 80));
        imagePanelWrapper.add(imagePanel, BorderLayout.CENTER);
        add(imagePanelWrapper, BorderLayout.CENTER);
    }

    private void setupListener() {
        thumbnailList.addThumbnailSelectionListener(e -> {
            currentImageIndex = thumbnailList.getSelectedIndex();
            showImage(currentImageIndex);
            if (timer != null) {
                timer.restart();
            }
        });
    }

    private void slideshow() {
        showImage(currentImageIndex);

        timer = new Timer(5000, e -> showNextImage());
        timer.start();
    }

    private void showImage(int index) {
        imagePanel.setImage(images[index]);
        thumbnailList.setSelectedThumbnail(index);
    }

    private void showNextImage() {
        if (++currentImageIndex >= images.length) currentImageIndex = 0;
        showImage(currentImageIndex);
    }
}
