package pl.pjatk.s36691.gui.zad58.util;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {

    public static Font loadFont(String path) {
        try (InputStream fontStream = FontLoader.class.getResourceAsStream(path)) {
            if (fontStream == null) {
                throw new IOException("Font resource not found: " + path);
            }
            return Font.createFont(
                    Font.TRUETYPE_FONT,
                    fontStream
            );
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font(Font.SANS_SERIF, Font.PLAIN, 16);
        }
    }
}
