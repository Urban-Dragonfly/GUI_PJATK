package pl.pjatk.s36691.gui.zad58.model;

public class GameModel {

    private final BoardModel board;
    private final Player playerOne;
    private final Player playerTwo;

    private Player currentPlayer;

    public GameModel(BoardModel board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = playerOne;
    }

    public void decreaseCurrentPlayerTime() {
        currentPlayer.decreaseTime();
    }

    public boolean currentPlayerCanMove() {
        return currentPlayer.canMove();
    }

    public void switchTurn() {
        if (currentPlayer == playerOne && playerTwo.canMove()) {
            currentPlayer = playerTwo;
        } else if (currentPlayer == playerTwo && playerOne.canMove()) {
            currentPlayer = playerOne;
        }
    }

    public boolean isGameOver() {
        return board.allCardsMatched()
                || (!playerOne.canMove() && !playerTwo.canMove());
    }

    public BoardModel getBoard() {
        return board;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
