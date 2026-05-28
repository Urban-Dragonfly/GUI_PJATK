package pl.pjatk.s36691.gui.zad61;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class ImageGetter {
    private File directory;
    private final boolean picturesPresent;
    private final File[] picturePaths;

    public ImageGetter() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            this.directory = fileChooser.getSelectedFile();
            this.picturePaths = getPicturesPaths();
            this.picturesPresent = picturePaths.length > 0;
        } else {
            this.picturePaths = new File[0];
            this.picturesPresent = false;
        }

    }

    private File[] getPicturesPaths() {
        File[] files = directory.listFiles();
        if (files == null) {
            return new File[0];
        }
        return Arrays.stream(files)
                .filter(File::isFile)
                .filter(this::isImageFile)
                .toArray(File[]::new);
    }

    private boolean isImageFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg")
                || name.endsWith(".jpeg")
                || name.endsWith(".png")
                || name.endsWith(".gif");
    }

    public Image[] loadImages() {
        Image[] images = new Image[picturePaths.length];

        for (int i = 0; i < picturePaths.length; i++) {
            ImageIcon icon = new ImageIcon(picturePaths[i].getAbsolutePath());
            images[i] = icon.getImage();
        }

        return images;
    }

    public boolean isPicturesPresent() {
        return picturesPresent;
    }
}
