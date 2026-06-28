package pl.pjatk.s36691.gui.zad63.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.util.List;
import java.util.stream.Stream;
import java.util.Locale;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

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
    private ToggleButton shuffleButton;

    @FXML
    private ToggleButton loopToggleButton;

    private final MusicLibraryService musicLibraryService = new MusicLibraryService();
    private ObservableList<Song> allSongs;
    private FilteredList<Song> filteredSongs;
    private Song currentSong;
    private MediaPlayer mediaPlayer;
    private Song loadedSong;
    private boolean userChangingSlider;
    private final Random random = new Random();
    private final List<Song> shuffledQueue = new ArrayList<>();

    @FXML
    private void initialize() {
        nowPlayingLabel.setText("No track selected");
        currentTimeLabel.setText("00:00");
        totalTimeLabel.setText("00:00");
        progressSlider.setMin(0);
        progressSlider.setMax(1);
        progressSlider.setValue(0);

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

                    if (!isPlaying()) {
                        updateNowPlayingLabel();
                    }
                });
    }

    private void updateNowPlayingLabel() {
        Song songToDisplay = isPlaying() ? loadedSong : currentSong;

        if (songToDisplay != null) {
            nowPlayingLabel.setText(songToDisplay.artist() + " - " + songToDisplay.title());
        } else {
            nowPlayingLabel.setText("No track selected");
        }
    }

    private boolean isPlaying() {
        return mediaPlayer != null
                && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING;
    }

    private void initializePlayerControls() {
        playPauseButton.setOnAction(event -> handlePlayPause());
        stopButton.setOnAction(event -> handleStop());
        shuffleButton.setOnAction(event -> handleShuffleToggle());
        initializeProgressSlider();
    }

    private void handlePlayPause() {
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            playPauseButton.setText("▶");
            return;
        }

        if (currentSong == null) {
            currentSong = songsTableView.getSelectionModel().getSelectedItem();
        }

        if (currentSong == null) {
            nowPlayingLabel.setText("Select a track first");
            return;
        }

        if (mediaPlayer == null || loadedSong == null || !loadedSong.equals(currentSong)) {
            playSong(currentSong);
            return;
        }

        mediaPlayer.play();
        playPauseButton.setText("⏸");
        updateNowPlayingLabel();
    }

    private void playSong(Song song) {
        if (song == null) {
            nowPlayingLabel.setText("Select a track first");
            return;
        }

        currentSong = song;
        songsTableView.getSelectionModel().select(song);

        loadCurrentSong();

        if (mediaPlayer == null) {
            return;
        }

        mediaPlayer.play();
        playPauseButton.setText("⏸");
        updateNowPlayingLabel();
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
        connectPlayerToProgress();
        updateNowPlayingLabel();
    }

    private void connectPlayerToProgress() {
        mediaPlayer.setOnReady(() -> {
            Duration totalDuration = mediaPlayer.getTotalDuration();

            totalTimeLabel.setText(formatDuration(totalDuration));
            progressSlider.setMax(totalDuration.toSeconds());
            progressSlider.setValue(0);
            currentTimeLabel.setText("00:00");
        });

        mediaPlayer.currentTimeProperty().addListener((observable, oldTime, newTime) -> {
            currentTimeLabel.setText(formatDuration(newTime));

            if (!userChangingSlider) {
                progressSlider.setValue(newTime.toSeconds());
            }
        });

        mediaPlayer.setOnEndOfMedia(() -> {
            progressSlider.setValue(progressSlider.getMax());
            currentTimeLabel.setText(totalTimeLabel.getText());
            playNextSong();
        });
    }

    private String formatDuration(Duration duration) {
        if (duration == null || duration.isUnknown() || duration.isIndefinite()) {
            return "00:00";
        }

        int totalSeconds = (int) Math.floor(duration.toSeconds());

        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    private void handleStop() {
        if (mediaPlayer == null) {
            return;
        }

        mediaPlayer.stop();
        mediaPlayer.seek(Duration.ZERO);

        playPauseButton.setText("▶");
        currentTimeLabel.setText("00:00");
        progressSlider.setValue(0);
    }

    private void initializeProgressSlider() {
        progressSlider.setOnMousePressed(event -> userChangingSlider = true);

        progressSlider.setOnMouseReleased(event -> {
            userChangingSlider = false;
            seekToSliderValue();
        });
    }

    private void seekToSliderValue() {
        if (mediaPlayer == null) {
            return;
        }

        mediaPlayer.seek(Duration.seconds(progressSlider.getValue()));
    }

    private void playNextSong() {
        if (shuffleButton.isSelected()) {
            playNextShuffledSong();
            return;
        }

        List<Song> visibleSongs = songsTableView.getItems();

        if (visibleSongs.isEmpty() || loadedSong == null) {
            finishPlaylistPlayback();
            return;
        }

        int currentIndex = visibleSongs.indexOf(loadedSong);

        if (currentIndex == -1) {
            finishPlaylistPlayback();
            return;
        }

        int nextIndex = currentIndex + 1;

        if (nextIndex >= visibleSongs.size()) {
            if (loopToggleButton.isSelected()) {
                nextIndex = 0;
            } else {
                finishPlaylistPlayback();
                return;
            }
        }

        Song nextSong = visibleSongs.get(nextIndex);
        playSong(nextSong);
    }

    private void playNextShuffledSong() {
        if (shuffledQueue.isEmpty()) {
            if (loopToggleButton.isSelected()) {
                rebuildShuffleQueue();
            } else {
                finishPlaylistPlayback();
                return;
            }
        }

        if (shuffledQueue.isEmpty()) {
            finishPlaylistPlayback();
            return;
        }

        Song nextSong = shuffledQueue.removeFirst();
        playSong(nextSong);
    }

    private void handleShuffleToggle() {
        shuffledQueue.clear();

        if (shuffleButton.isSelected()) {
            rebuildShuffleQueue();
        }
    }

    private void rebuildShuffleQueue() {
        shuffledQueue.clear();

        for (Song song : songsTableView.getItems()) {
            if (!song.equals(loadedSong)) {
                shuffledQueue.add(song);
            }
        }

        Collections.shuffle(shuffledQueue, random);
    }

    private void finishPlaylistPlayback() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.seek(Duration.ZERO);
        }

        playPauseButton.setText("▶");
        currentTimeLabel.setText("00:00");
        progressSlider.setValue(0);
    }
}
