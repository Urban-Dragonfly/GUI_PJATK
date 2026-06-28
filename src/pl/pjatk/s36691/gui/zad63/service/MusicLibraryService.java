package pl.pjatk.s36691.gui.zad63.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pjatk.s36691.gui.zad63.model.Song;

public class MusicLibraryService {

    public ObservableList<Song> getSongs() {
        return FXCollections.observableArrayList(
                new Song(
                        "Neon Login",
                        "FXML Tigers",
                        "Controller Nights",
                        "Electronic",
                        "/pl/pjatk/s36691/gui/zad63/music/audio/01_neon_login.wav"
                ),
                new Song(
                        "Null Pointer Waltz",
                        "Runtime Orchestra",
                        "Exceptions And Coffee",
                        "Classical",
                        "/pl/pjatk/s36691/gui/zad63/music/audio/02_null_pointer_waltz.wav"
                ),
                new Song(
                        "Garbage Collector Groove",
                        "Heap Space",
                        "Memory Leaks",
                        "Funk",
                        "/pl/pjatk/s36691/gui/zad63/music/audio/03_garbage_collector_groove.wav"
                ),
                new Song(
                        "FXML Blues",
                        "The Layout Managers",
                        "BorderPane Stories",
                        "Blues",
                        "/pl/pjatk/s36691/gui/zad63/music/audio/04_fxml_blues.wav"
                ),
                new Song(
                        "Recursive Cat",
                        "Stack Overflow Quartet",
                        "Base Case Missing",
                        "Rock",
                        "/pl/pjatk/s36691/gui/zad63/music/audio/05_recursive_cat.wav"
                ),
                new Song(
                        "Observable Rain",
                        "Bindings",
                        "Properties",
                        "Ambient",
                        "/pl/pjatk/s36691/gui/zad63/music/audio/06_observable_rain.wav"
                )
        );
    }
}