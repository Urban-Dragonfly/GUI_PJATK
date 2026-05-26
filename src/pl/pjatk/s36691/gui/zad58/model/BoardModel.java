package pl.pjatk.s36691.gui.zad58.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardModel {

    private final int rows;
    private final int columns;
    private final List<Card> cards;

    public BoardModel(int rows, int columns, List<Card> cards) {
        if (rows * columns != cards.size()) {
            throw new IllegalArgumentException("Number of cards must match board size.");
        }

        this.rows = rows;
        this.columns = columns;
        this.cards = new ArrayList<>(cards);

        Collections.shuffle(this.cards);
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int size() {
        return cards.size();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean allCardsMatched() {
        for (Card card : cards) {
            if (!card.isMatched()) {
                return false;
            }
        }

        return true;
    }
}