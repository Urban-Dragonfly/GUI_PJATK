package pl.pjatk.s36691.gui.zad58.view;

import pl.pjatk.s36691.gui.zad58.model.Card;
import pl.pjatk.s36691.gui.zad58.model.BoardModel;
import pl.pjatk.s36691.gui.zad58.model.CardFactory;
import pl.pjatk.s36691.gui.zad58.util.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class MemoryCatsFrame extends JFrame {

    private static final String TITLE_BACKGROUND_PATH =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/titlebar.png";
    private static final String BOARD_BACKGROUND_PATH =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/board_frame.png";
    private static final String SIDE_PANEL_BACKGROUND_PATH =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/side_menu.png";

    private final Font titleFont;
    private final Font buttonFont;
    private final Font labelFont;

    private MenuPanel menuPanel;
    private BoardPanel boardPanel;
    private CardsFoundPanel cardsFoundPanel;

    public MemoryCatsFrame(Font arcadeFont) {
        this.titleFont = arcadeFont.deriveFont(Font.PLAIN, 48f);
        this.buttonFont = arcadeFont.deriveFont(Font.PLAIN, 24f);
        this.labelFont = arcadeFont.deriveFont(Font.PLAIN, 16f);

        initComponents();
        setupFrame();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        TitlePanel titlePanel = createTitlePanel();
        boardPanel = createBoardPanel();
        menuPanel = createMenuPanel();
        cardsFoundPanel = createCardsFoundPanel();

        SquareWrapperPanel boardWrapperPanel = new SquareWrapperPanel(boardPanel);

        add(titlePanel, BorderLayout.NORTH);
        add(boardWrapperPanel, BorderLayout.CENTER);
        add(menuPanel, BorderLayout.WEST);
        add(cardsFoundPanel, BorderLayout.EAST);
    }

    private TitlePanel createTitlePanel() {
        Image titleBackground = ImageLoader.loadImage(TITLE_BACKGROUND_PATH);
        return new TitlePanel(titleBackground, titleFont);
    }

    private BoardPanel createBoardPanel() {
        Image boardBackground = ImageLoader.loadImage(BOARD_BACKGROUND_PATH);

        int rows = 8;
        int columns = 8;

        List<Card> cards = CardFactory.createCardsForBoard(rows, columns);
        BoardModel boardModel = new BoardModel(rows, columns, cards);

        return new BoardPanel(boardModel);
    }

    private MenuPanel createMenuPanel() {
        Image menuBackground = ImageLoader.loadImage(SIDE_PANEL_BACKGROUND_PATH);
        return new MenuPanel(menuBackground, labelFont, buttonFont);
    }

    private CardsFoundPanel createCardsFoundPanel() {
        Image cardsFoundBackground = ImageLoader.loadImage(SIDE_PANEL_BACKGROUND_PATH);
        return new CardsFoundPanel(cardsFoundBackground, buttonFont);
    }

    private void setupFrame() {
        setTitle("Memory Cats");
        setSize(1280, 900);
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }
}
