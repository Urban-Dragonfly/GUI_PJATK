package pl.pjatk.s36691.gui.zad58.view;

import pl.pjatk.s36691.gui.zad58.model.Card;
import pl.pjatk.s36691.gui.zad58.model.BoardModel;
import pl.pjatk.s36691.gui.zad58.model.CardFactory;
import pl.pjatk.s36691.gui.zad58.util.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MemoryCatsFrame extends JFrame {

    private static final String TITLE_BACKGROUND_PATH =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/titlebar.png";
    private static final String SIDE_PANEL_BACKGROUND_PATH =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/side_menu.png";
    private static final String[] APP_ICON_PATHS = {
            "/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_16.png",
            "/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_24.png",
            "/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_32.png",
            "/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_48.png",
            "/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_64.png",
            "/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_128.png",
            "/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_256.png",
            "/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_512.png"
    };

    private final Font titleFont;
    private final Font buttonFont;
    private final Font labelFont;

    private TitlePanel titlePanel;
    private MenuPanel menuPanel;
    private BoardPanel boardPanel;
    private SquareWrapperPanel boardWrapperPanel;
    private CardsFoundPanel cardsFoundPanel;

    private JPanel leftSideWrapper;
    private JPanel rightSideWrapper;

    private static final int BASE_FRAME_WIDTH = 1280;
    private static final int SIDE_PANEL_WIDTH = 260;
    private static final int MAX_SIDE_EXTRA_WIDTH = 300;

    public MemoryCatsFrame(Font arcadeFont) {
        this.titleFont = arcadeFont.deriveFont(Font.PLAIN, 48f);
        this.buttonFont = arcadeFont.deriveFont(Font.PLAIN, 24f);
        this.labelFont = arcadeFont.deriveFont(Font.PLAIN, 16f);

        initComponents();
        setupFrame();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        titlePanel = createTitlePanel();
        boardPanel = createBoardPanel();
        menuPanel = createMenuPanel();
        cardsFoundPanel = createCardsFoundPanel();

        boardWrapperPanel = new SquareWrapperPanel(boardPanel);
        leftSideWrapper = createCenteredSideWrapper(menuPanel);
        rightSideWrapper = createCenteredSideWrapper(cardsFoundPanel);

        add(titlePanel, BorderLayout.NORTH);
        add(boardWrapperPanel, BorderLayout.CENTER);
        add(leftSideWrapper, BorderLayout.WEST);
        add(rightSideWrapper, BorderLayout.EAST);
    }

    private TitlePanel createTitlePanel() {
        Image titleBackground = ImageLoader.loadImage(TITLE_BACKGROUND_PATH);
        return new TitlePanel(titleBackground, titleFont);
    }

    private BoardPanel createBoardPanel() {
        int rows = 4;
        int columns = 4;

        List<Card> cards = CardFactory.createCardsForBoard(rows, columns);
        BoardModel boardModel = new BoardModel(rows, columns, cards);

        return new BoardPanel(boardModel);
    }

    public void setBoardPanel(BoardPanel newBoardPanel) {
        boardPanel = newBoardPanel;
        setCenterComponent(boardPanel);
    }

    private JPanel createCenteredSideWrapper(JComponent child) {
        JPanel wrapper = new JPanel(null) {
            @Override
            public void doLayout() {
                int childWidth = Math.min(SIDE_PANEL_WIDTH, getWidth());
                int childHeight = getHeight();

                int x = (getWidth() - childWidth) / 2;

                child.setBounds(x, 0, childWidth, childHeight);
            }
        };
        wrapper.setBackground(Color.BLACK);
        wrapper.setOpaque(true);
        wrapper.add(child);
        wrapper.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, 1));

        return wrapper;
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
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                updateSideWrapperWidths();
            }
        });
        setTitle("Memory Cats");
        setIconImages(List.of(
                ImageLoader.loadImage("/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_16.png"),
                ImageLoader.loadImage("/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_32.png"),
                ImageLoader.loadImage("/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_64.png"),
                ImageLoader.loadImage("/pl/pjatk/s36691/gui/zad58/assets/ui/app_icon_256.png")
        ));
        setIconImages(loadAppIcons());
        setSize(1280, 900);
        setMinimumSize(new Dimension(1280, 900));
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        updateSideWrapperWidths();
    }

    private List<Image> loadAppIcons() {
        List<Image> icons = new ArrayList<>();

        for (String iconPath : APP_ICON_PATHS) {
            icons.add(ImageLoader.loadImage(iconPath));
        }

        return icons;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public TitlePanel getTitlePanel() {
        return titlePanel;
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public CardsFoundPanel getCardsFoundPanel() {
        return cardsFoundPanel;
    }

    public void setBoardCardsEnabled(boolean enabled) {
        boardPanel.setCardsEnabled(enabled);
    }

    private void setCenterComponent(Component component) {
        boardWrapperPanel.removeAll();
        boardWrapperPanel.add(component);
        boardWrapperPanel.revalidate();
        boardWrapperPanel.repaint();
    }

    public void showCardPreview(String imagePath) {
        Image image = ImageLoader.loadImage(imagePath);
        CardPreviewPanel previewPanel = new CardPreviewPanel(image);

        setCenterComponent(previewPanel);
    }

    private void updateSideWrapperWidths() {
        int extraWidth = Math.max(0, getWidth() - BASE_FRAME_WIDTH);

        int extraSideWidth = Math.min(MAX_SIDE_EXTRA_WIDTH, extraWidth / 4);

        int wrapperWidth = SIDE_PANEL_WIDTH + extraSideWidth;

        Dimension size = new Dimension(wrapperWidth, 0);

        leftSideWrapper.setPreferredSize(size);
        rightSideWrapper.setPreferredSize(size);

        leftSideWrapper.revalidate();
        rightSideWrapper.revalidate();
    }
}
