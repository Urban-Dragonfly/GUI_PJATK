package pl.pjatk.s36691.gui.zad58.view;

import pl.pjatk.s36691.gui.zad58.model.Card;
import pl.pjatk.s36691.gui.zad58.model.BoardModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import static pl.pjatk.s36691.gui.zad58.util.ImageLoader.loadImage;

public class BoardPanel extends JPanel {

    private static final String CARD_BACK_PATH =
            "/pl/pjatk/s36691/gui/zad58/assets/cards/card_back.png";

    private final BoardModel boardModel;
    private final List<CardButton> cardButtons = new ArrayList<>();

    public BoardPanel(BoardModel boardModel) {

        this.boardModel = boardModel;

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

        revalidate();
        repaint();
    }

    private CardButton createCardButton(Card card, int index) {
        CardButton button = new CardButton(loadImage(CARD_BACK_PATH));

        button.addActionListener(e -> {
            System.out.println("Clicked card index: " + index);
            System.out.println("Pair ID: " + card.getPairId());
            System.out.println("Front: " + card.getImagePath());
        });

        return button;
    }

}