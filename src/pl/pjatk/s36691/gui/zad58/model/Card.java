package pl.pjatk.s36691.gui.zad58.model;

public class Card {

    private final int pairId;
    private final String imagePath;

    private boolean revealed;
    private boolean matched;

    public Card(int pairId, String imagePath) {
        this.pairId = pairId;
        this.imagePath = imagePath;
        this.revealed = false;
        this.matched = false;
    }

    public int getPairId() {
        return pairId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public boolean isMatched() {
        return matched;
    }

    public void reveal() {
        if (!matched) {
            revealed = true;
        }
    }

    public void hide() {
        if (!matched) {
            revealed = false;
        }
    }

    public void markAsMatched() {
        matched = true;
        revealed = true;
    }
}
