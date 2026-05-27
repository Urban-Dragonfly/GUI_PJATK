package pl.pjatk.s36691.gui.zad58.controller;

import pl.pjatk.s36691.gui.zad58.model.*;
import pl.pjatk.s36691.gui.zad58.view.MemoryCatsFrame;
import pl.pjatk.s36691.gui.zad58.view.BoardPanel;

import javax.swing.*;
import java.util.List;

public class GameController {

    private final MemoryCatsFrame frame;

    private Timer gameTimer;
    private Timer pairResolveTimer;
    private boolean gameRunning;

    private int currentPlayer = 1;
    private int playerOneRemainingSeconds;
    private int playerTwoRemainingSeconds;
    private int playerOneScore;
    private int playerTwoScore;
    private int playerOneMoves;
    private int playerTwoMoves;

    private static final int NO_CARD_SELECTED = -1;
    private int firstSelectedCardIndex = NO_CARD_SELECTED;
    private boolean resolvingPair;

    private boolean[] matchedCards;

    public GameController(MemoryCatsFrame frame) {
        this.frame = frame;
        initDifficultyListeners();
        initPlayerCountListeners();
        initStartResetListeners();
        connectBoardPanel();
        connectCardsFoundPanel();
        resetCardSelectionState();
    }

    private void initDifficultyListeners() {
        frame.getMenuPanel().getEasyButton().addActionListener(e -> dealNewBoard());
        frame.getMenuPanel().getMediumButton().addActionListener(e -> dealNewBoard());
        frame.getMenuPanel().getHardButton().addActionListener(e -> dealNewBoard());
    }

    private void initPlayerCountListeners() {
        frame.getMenuPanel().getOnePlayerButton().addActionListener(e -> updatePlayerModeView());
        frame.getMenuPanel().getTwoPlayersButton().addActionListener(e -> updatePlayerModeView());
    }

    private void initStartResetListeners() {
        frame.getMenuPanel().getStartButton().addActionListener(e -> handleStartButtonClick());
        frame.getMenuPanel().getResetButton().addActionListener(e -> handleResetButtonClick());
    }

    private void dealNewBoard() {
        Difficulty difficulty = frame.getMenuPanel().getSelectedDifficulty();
        int rows = difficulty.getRows();
        int columns = difficulty.getColumns();

        List<Card> cards = CardFactory.createCardsForBoard(rows, columns);

        BoardModel boardModel = new BoardModel(rows, columns, cards);

        BoardPanel boardPanel = new BoardPanel(boardModel);

        frame.setBoardPanel(boardPanel);

        connectBoardPanel();

        resetCardSelectionState();
    }

    private void connectBoardPanel() {
        frame.getBoardPanel().setCardClickedListener(this::handleCardClick);
    }

    private void handleCardClick(int cardIndex) {
        if (!gameRunning) return;
        if (resolvingPair) return;
        if (matchedCards[cardIndex]) return;
        if (cardIndex == firstSelectedCardIndex) return;

        frame.getBoardPanel().revealCard(cardIndex);
        frame.getBoardPanel().setCardEnabled(cardIndex, false);

        if (firstSelectedCardIndex == NO_CARD_SELECTED) {
            firstSelectedCardIndex = cardIndex;
            return;
        }

        int secondSelectedCardIndex = cardIndex;

        incrementCurrentPlayerMoves();

        Card firstCard = frame.getBoardPanel().getCard(firstSelectedCardIndex);
        Card secondCard = frame.getBoardPanel().getCard(secondSelectedCardIndex);

        if (firstCard.getPairId() == secondCard.getPairId()) {
            handleMatchedPair(firstSelectedCardIndex, secondSelectedCardIndex);
        } else {
            handleMismatchedPair(firstSelectedCardIndex, secondSelectedCardIndex);
        }
    }

    private void handleMatchedPair(int firstIndex, int secondIndex) {
        matchedCards[firstIndex] = true;
        matchedCards[secondIndex] = true;



        incrementCurrentPlayerScore();

        firstSelectedCardIndex = NO_CARD_SELECTED;
        resolvingPair = true;

        pairResolveTimer = new Timer(400, e -> {
            frame.getBoardPanel().setCardVisible(firstIndex, false);
            frame.getBoardPanel().setCardVisible(secondIndex, false);

            Card matchedCard = frame.getBoardPanel().getCard(firstIndex);
            frame.getCardsFoundPanel().addFoundCard(matchedCard.getImagePath());

            resolvingPair = false;
            pairResolveTimer = null;

            if (getTotalScore() == matchedCards.length / 2) {
                handleAllCardsMatched();
            }
        });

        pairResolveTimer.setRepeats(false);
        pairResolveTimer.start();
    }

    private void handleMismatchedPair(int firstIndex, int secondIndex) {
        resolvingPair = true;

        pairResolveTimer = new Timer(900, e -> {
            frame.getBoardPanel().hideCard(firstIndex);
            frame.getBoardPanel().hideCard(secondIndex);

            frame.getBoardPanel().setCardEnabled(firstIndex, true);
            frame.getBoardPanel().setCardEnabled(secondIndex, true);

            firstSelectedCardIndex = NO_CARD_SELECTED;
            resolvingPair = false;

            switchPlayerAfterMismatch();

            pairResolveTimer = null;
        });

        pairResolveTimer.setRepeats(false);
        pairResolveTimer.start();
    }

    private void switchPlayerAfterMismatch() {
        if (!isTwoPlayersMode()) {
            return;
        }

        if (currentPlayer == 1 && playerTwoRemainingSeconds > 0) {
            currentPlayer = 2;
        } else if (currentPlayer == 2 && playerOneRemainingSeconds > 0) {
            currentPlayer = 1;
        }

        frame.getMenuPanel().setActivePlayer(currentPlayer);
    }

    private void handleAllCardsMatched() {
        if (!isTwoPlayersMode()) {
            handleSinglePlayerWin();
            return;
        }

        finishGame();

        if (playerOneScore > playerTwoScore) {
            frame.getTitlePanel().showPlayerOneWonTitle();
        } else if (playerTwoScore > playerOneScore) {
            frame.getTitlePanel().showPlayerTwoWonTitle();
        } else {
            frame.getTitlePanel().showTieTitle();
        }
    }

    private void handleSinglePlayerWin() {
        finishGame();
        frame.getTitlePanel().showYouWonTitle();
    }

    private void handleGameOver() {
        finishGame();
        frame.getTitlePanel().showGameOverTitle();
    }

    private void updatePlayerModeView() {
        int selectedPlayerCount = frame.getMenuPanel().getSelectedPlayerCount();

        frame.getMenuPanel().setPlayerTwoPanelVisible(selectedPlayerCount == 2);
    }

    private void handleStartButtonClick() {
        gameRunning = true;

        currentPlayer = 1;
        frame.getMenuPanel().setActivePlayer(currentPlayer);

        playerOneScore = 0;
        playerTwoScore = 0;
        playerOneMoves = 0;
        playerTwoMoves = 0;

        frame.getMenuPanel().updatePlayerOneScore(playerOneScore);
        frame.getMenuPanel().updatePlayerTwoScore(playerTwoScore);
        frame.getMenuPanel().updatePlayerOneMoves(playerOneMoves);
        frame.getMenuPanel().updatePlayerTwoMoves(playerTwoMoves);

        frame.getMenuPanel().setPreGameControlsEnabled(false);

        setInitialPlayerTimes();

        frame.setBoardCardsEnabled(true);

        startGameTimer();
    }

    private void handleResetButtonClick() {
        finishGame();

        frame.getMenuPanel().setPreGameControlsEnabled(true);

        frame.getMenuPanel().resetPlayerInfo();
        frame.getMenuPanel().resetPlayerColors();

        frame.getCardsFoundPanel().clearFoundCards();

        updatePlayerModeView();

        frame.getTitlePanel().resetTitle();

        dealNewBoard();
    }

    private String formatTime(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private void setInitialPlayerTimes() {
        Difficulty difficulty = frame.getMenuPanel().getSelectedDifficulty();

        playerOneRemainingSeconds = difficulty.getSeconds();

        if (isTwoPlayersMode()) {
            playerTwoRemainingSeconds = difficulty.getSeconds();
        } else {
            playerTwoRemainingSeconds = 0;
        }

        frame.getMenuPanel().updatePlayerOneTime(formatTime(playerOneRemainingSeconds));
        frame.getMenuPanel().updatePlayerTwoTime(formatTime(playerTwoRemainingSeconds));
    }

    private void startGameTimer() {
        stopGameTimer();
        gameTimer = new Timer(1000, e -> updateTimer());
        gameTimer.start();
    }
    private void stopGameTimer() {
        if (gameTimer != null) {
            gameTimer.stop();
            gameTimer = null;
        }
    }

    private void updateTimer() {
        if (!isTwoPlayersMode()) {
            updateSinglePlayerTimer();
            return;
        }

        updateTwoPlayersTimer();
    }

    private void updateSinglePlayerTimer() {
        if (playerOneRemainingSeconds > 0) {
            playerOneRemainingSeconds--;
            frame.getMenuPanel().updatePlayerOneTime(formatTime(playerOneRemainingSeconds));
        }

        if (playerOneRemainingSeconds == 0) {
            handleGameOver();
        }
    }

    private void updateTwoPlayersTimer() {
        if (currentPlayer == 1) {
            updatePlayerOneTimer();
        } else {
            updatePlayerTwoTimer();
        }

        if (playerOneRemainingSeconds == 0 && playerTwoRemainingSeconds == 0) {
            handleBothPlayersOutOfTime();
        }
    }

    private void updatePlayerOneTimer() {
        if (playerOneRemainingSeconds > 0) {
            playerOneRemainingSeconds--;
            frame.getMenuPanel().updatePlayerOneTime(formatTime(playerOneRemainingSeconds));
        }

        if (playerOneRemainingSeconds == 0 && playerTwoRemainingSeconds > 0) {
            currentPlayer = 2;
            frame.getMenuPanel().setActivePlayer(currentPlayer);
        }
    }

    private void updatePlayerTwoTimer() {
        if (playerTwoRemainingSeconds > 0) {
            playerTwoRemainingSeconds--;
            frame.getMenuPanel().updatePlayerTwoTime(formatTime(playerTwoRemainingSeconds));
        }

        if (playerTwoRemainingSeconds == 0 && playerOneRemainingSeconds > 0) {
            currentPlayer = 1;
            frame.getMenuPanel().setActivePlayer(currentPlayer);
        }
    }

    private void handleBothPlayersOutOfTime() {
        finishGame();
        showTwoPlayerResult();
    }

    private void showTwoPlayerResult() {
        if (playerOneScore > playerTwoScore) {
            frame.getTitlePanel().showPlayerOneWonTitle();
        } else if (playerTwoScore > playerOneScore) {
            frame.getTitlePanel().showPlayerTwoWonTitle();
        } else {
            frame.getTitlePanel().showTieTitle();
        }
    }

    private void resetCardSelectionState() {
        firstSelectedCardIndex = NO_CARD_SELECTED;
        resolvingPair = false;
        matchedCards = new boolean[frame.getBoardPanel().getCardCount()];
    }

    private void stopPairResolveTimer() {
        if (pairResolveTimer != null) {
            pairResolveTimer.stop();
            pairResolveTimer = null;
        }

        resolvingPair = false;
        firstSelectedCardIndex = NO_CARD_SELECTED;
    }

    private boolean isTwoPlayersMode() {
        return frame.getMenuPanel().getSelectedPlayerCount() == 2;
    }

    private void incrementCurrentPlayerMoves() {
        if (currentPlayer == 1) {
            playerOneMoves++;
            frame.getMenuPanel().updatePlayerOneMoves(playerOneMoves);
        } else {
            playerTwoMoves++;
            frame.getMenuPanel().updatePlayerTwoMoves(playerTwoMoves);
        }
    }

    private void incrementCurrentPlayerScore() {
        if (currentPlayer == 1) {
            playerOneScore++;
            frame.getMenuPanel().updatePlayerOneScore(playerOneScore);
        } else {
            playerTwoScore++;
            frame.getMenuPanel().updatePlayerTwoScore(playerTwoScore);
        }
    }

    private int getTotalScore() {
        return playerOneScore + playerTwoScore;
    }

    private void finishGame() {
        gameRunning = false;
        stopGameTimer();
        stopPairResolveTimer();
        frame.setBoardCardsEnabled(false);
    }

    private void connectCardsFoundPanel() {
        frame.getCardsFoundPanel().setFoundCardClickListener(this::handleFoundCardClick);
    }

    private void handleFoundCardClick(String imagePath) {
        if (gameRunning) {
            return;
        }

        frame.showCardPreview(imagePath);
    }
}
