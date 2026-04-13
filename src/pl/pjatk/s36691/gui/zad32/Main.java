package pl.pjatk.s36691.gui.zad32;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try(Stream<String> info = Files.lines(Path.of("src/pl/pjatk/s36691/gui/zad31/info.txt"))) {
            long n = info
                    .flatMap(line -> Arrays.stream(line.split("[,.\\s]+")))
                    .filter(word -> word.length() > 8)
                    .count();

            System.out.println("Ilość słów dłuższych niż osiem liter: " + n);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
