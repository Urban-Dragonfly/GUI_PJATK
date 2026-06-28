package pl.pjatk.s36691.gui.zad63.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.List;
import java.util.stream.Stream;
import java.util.Locale;

import java.net.URL;

import pl.pjatk.s36691.gui.zad63.model.Song;
import pl.pjatk.s36691.gui.zad63.service.MusicLibraryService;



public class PlayerController {


    @FXML
    private Label nowPlayingLabel;

    @FXML
    private Label currentTimeLabel;

    @FXML
    private Label totalTimeLabel;

    @FXML
    private Slider progressSlider;

    @FXML
    private ListView<String> categoriesListView;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Song> songsTableView;

    @FXML
    private TableColumn<Song, String> titleColumn;

    @FXML
    private TableColumn<Song, String> artistColumn;

    @FXML
    private TableColumn<Song, String> albumColumn;

    @FXML
    private TableColumn<Song, String> categoryColumn;

    @FXML
    private Button playPauseButton;

    @FXML
    private Button stopButton;

    @FXML
    private Button shuffleButton;

    @FXML
    private ToggleButton loopToggleButton;

    private final MusicLibraryService musicLibraryService = new MusicLibraryService();
    private ObservableList<Song> allSongs;
    private FilteredList<Song> filteredSongs;
    private Song currentSong;
    private MediaPlayer mediaPlayer;
    private Song loadedSong;

    @FXML
    private void initialize() {
        nowPlayingLabel.setText("No track selected");
        currentTimeLabel.setText("00:00");
        totalTimeLabel.setText("00:00");

        titleColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().title()));

        artistColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().artist()));

        albumColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().album()));

        categoryColumn.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().category()));

        allSongs = musicLibraryService.getSongs();

        filteredSongs = new FilteredList<>(allSongs, song -> true);

        SortedList<Song> sortedSongs = new SortedList<>(filteredSongs);
        sortedSongs.comparatorProperty().bind(songsTableView.comparatorProperty());

        songsTableView.setItems(sortedSongs);

        initializeCategories();
        initializeFilters();
        initializeSongSelection();
        initializePlayerControls();
    }

    private void initializeCategories() {
        List<String> categories = Stream.concat(
                Stream.of("All"),
                allSongs.stream()
                        .map(Song::category)
                        .distinct()
                        .sorted()
        ).toList();

        categoriesListView.getItems().setAll(categories);
        categoriesListView.getSelectionModel().select("All");
    }

    private void initializeFilters() {
        searchField.textProperty().addListener((observable, oldValue, newValue) -> updateFilter());

        categoriesListView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> updateFilter());

                updateFilter();
    }

    private void updateFilter() {
        String selectedCategory = categoriesListView.getSelectionModel().getSelectedItem();

        String searchText = searchField.getText();
        String normalizedSearchText = searchText == null
                ? ""
                : searchText.toLowerCase(Locale.ROOT).trim();

        filteredSongs.setPredicate(song -> {
            boolean matchesCategory =
                    selectedCategory == null
                            || selectedCategory.equals("All")
                            || song.category().equals(selectedCategory);

            boolean matchesSearch =
                    normalizedSearchText.isEmpty()
                            || song.title().toLowerCase(Locale.ROOT).contains(normalizedSearchText)
                            || song.artist().toLowerCase(Locale.ROOT).contains(normalizedSearchText)
                            || song.album().toLowerCase(Locale.ROOT).contains(normalizedSearchText);

            return matchesCategory && matchesSearch;
        });
    }

    private void initializeSongSelection() {
        songsTableView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, odlSong, newSong) -> {
                    currentSong = newSong;
                });
    }

    private void updateNowPlayingLabel() {
        if (loadedSong != null) {
            nowPlayingLabel.setText(loadedSong.artist() + " - " + loadedSong.title());
        } else {
            nowPlayingLabel.setText("No track selected");
        }
    }

    private void initializePlayerControls() {
        playPauseButton.setOnAction(event -> handlePlayPause());
        stopButton.setOnAction(event -> handleStop());
    }

    private void handlePlayPause() {
        if (currentSong == null) {
            currentSong = songsTableView.getSelectionModel().getSelectedItem();
        }

        if (currentSong == null) {
            nowPlayingLabel.setText("Select a track first");
            return;
        }

        if (mediaPlayer == null || loadedSong != currentSong) {
            loadCurrentSong();

            if (mediaPlayer == null) {
                return;
            }

            mediaPlayer.play();
            playPauseButton.setText("⏸");
            return;
        }

        MediaPlayer.Status status = mediaPlayer.getStatus();

        if (status == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            playPauseButton.setText("▶");
        } else {
            mediaPlayer.play();
            playPauseButton.setText("⏸");
        }
    }

    private void loadCurrentSong() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
        }

        URL songUrl = getClass().getResource(currentSong.resourcePath());

        if (songUrl == null) {
            mediaPlayer = null;
            loadedSong = null;
            nowPlayingLabel.setText("Audio file not found: " + currentSong.title());
            playPauseButton.setText("▶");
            return;
        }

        Media media = new Media(songUrl.toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        loadedSong = currentSong;

        updateNowPlayingLabel();
    }

    private void handleStop() {
        if (mediaPlayer == null) {
            return;
        }

        mediaPlayer.stop();

        playPauseButton.setText("▶");
        currentTimeLabel.setText("00:00");
        progressSlider.setValue(0);
    }
}
