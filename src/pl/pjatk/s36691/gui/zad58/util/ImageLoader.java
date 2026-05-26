package pl.pjatk.s36691.gui.zad58.util;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class ImageLoader {

    public static Image loadImage(String path) {
        URL url = ImageLoader.class.getResource(path);

        if (url == null) {
            throw new IllegalArgumentException("Image resource not found: " + path);
        }

        return new ImageIcon(url).getImage();
    }
}
