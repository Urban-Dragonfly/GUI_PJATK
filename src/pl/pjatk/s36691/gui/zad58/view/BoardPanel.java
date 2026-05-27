package pl.pjatk.s36691.gui.zad58.view;

import pl.pjatk.s36691.gui.zad58.model.Card;
import pl.pjatk.s36691.gui.zad58.model.BoardModel;
import java.util.function.IntConsumer;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import static pl.pjatk.s36691.gui.zad58.util.ImageLoader.loadImage;

public class BoardPanel extends JPanel {

    private static final String CARD_BACK_PATH =
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_back.png";
    private static final String CARD_BACK_HOVER_PATH =
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_back_hover.png";
    private static final String CARD_BACK_PRESSED_PATH =
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_back_pressed.png";

    private final BoardModel boardModel;
    private final List<CardButton> cardButtons = new ArrayList<>();
    private final Image cardBackImage;
    private final Image cardBackHoverImage;
    private final Image cardBackPressedImage;

    private IntConsumer cardClickedListener;

    public BoardPanel(BoardModel boardModel) {

        this.boardModel = boardModel;
        this.cardBackImage = loadImage(CARD_BACK_PATH);
        this.cardBackHoverImage = loadImage(CARD_BACK_HOVER_PATH);
        this.cardBackPressedImage = loadImage(CARD_BACK_PRESSED_PATH);

        setPreferredSize(new Dimension(780, 780));
        setBackground(Color.BLACK);
        setLayout(new GridLayout(
                boardModel.getRows(),
                boardModel.getColumns(),
                8,
                8
        ));

        buildBoard();
    }

    private void buildBoard() {
        removeAll();
        cardButtons.clear();

        for (int i = 0; i < boardModel.size(); i++) {
            Card card = boardModel.getCard(i);
            CardButton button = createCardButton(card, i);

            cardButtons.add(button);
            add(button);
        }

        setCardsEnabled(false);

        revalidate();
        repaint();
    }

    private CardButton createCardButton(Card card, int index) {
        CardButton button = new CardButton(cardBackImage, cardBackHoverImage, cardBackPressedImage);

        button.addActionListener(e -> {
            if (cardClickedListener != null) {
                cardClickedListener.accept(index);
            }
        });

        return button;
    }

    public void setCardsEnabled(boolean enabled) {
        for (CardButton button : cardButtons) {
            button.setEnabled(enabled);
        }
    }

    public void setCardClickedListener(IntConsumer listener) {
        this.cardClickedListener = listener;
    }

    public Card getCard(int index) {
        return boardModel.getCard(index);
    }

    public void revealCard(int index) {
        Card card = getCard(index);
        Image frontImage = loadImage(card.getImagePath());

        CardButton button = cardButtons.get(index);
        button.setCardImage(frontImage);
    }

    public void hideCard(int index) {
        CardButton button = cardButtons.get(index);
        button.setCardImages(cardBackImage, cardBackHoverImage, cardBackPressedImage);
    }

    public int getCardCount() {
        return boardModel.size();
    }

    public void setCardEnabled(int index, boolean enabled) {
        cardButtons.get(index).setEnabled(enabled);
    }

    public void setCardVisible(int index, boolean visible) {
        cardButtons.get(index).setVisible(visible);
    }
}
