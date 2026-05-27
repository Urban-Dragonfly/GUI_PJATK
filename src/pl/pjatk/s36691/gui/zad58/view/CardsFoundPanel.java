package pl.pjatk.s36691.gui.zad58.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.function.Consumer;
import java.util.List;
import java.util.ArrayList;

import pl.pjatk.s36691.gui.zad58.util.ImageLoader;

public class CardsFoundPanel extends VerticalFiveSlicePanel {

    private static final String ARROW_UP_NORMAL_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/arrow_up_normal.png";
    private static final String ARROW_UP_HOVER_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/arrow_up_hover.png";
    private static final String ARROW_UP_PRESSED_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/arrow_up_pressed.png";
    private static final String ARROW_UP_BLOCKED_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/arrow_up_blocked.png";

    private static final String ARROW_DOWN_NORMAL_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/arrow_down_normal.png";
    private static final String ARROW_DOWN_HOVER_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/arrow_down_hover.png";
    private static final String ARROW_DOWN_PRESSED_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/arrow_down_pressed.png";
    private static final String ARROW_DOWN_BLOCKED_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/arrow_down_blocked.png";

    private static final int PANEL_WIDTH = 260;
    private static final int ARROW_WIDTH = 220;
    private static final int ARROW_HEIGHT = 55;

    private static final int FOUND_CARD_SIZE = 160;
    private static final int FOUND_CARD_ROW_HEIGHT = 168;
    private static final int FOUND_CARD_GAP = 16;

    private final JButton upButton;
    private final JButton downButton;
    private final JPanel foundCardsListPanel;

    private final List<String> foundCardImagePaths = new ArrayList<>();
    private Consumer<String> foundCardClickListener;

    private int firstVisibleCardIndex = 0;

    public CardsFoundPanel(Image backgroundImage, Font buttonFont) {
        super(backgroundImage);

        setPreferredSize(new Dimension(PANEL_WIDTH, 0));
        setMinimumSize(new Dimension(220, 0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBorder(BorderFactory.createEmptyBorder(48, 16, 48, 16));

        upButton = createArrowButton(
                ARROW_UP_NORMAL_ICON,
                ARROW_UP_HOVER_ICON,
                ARROW_UP_PRESSED_ICON,
                ARROW_UP_BLOCKED_ICON
        );

        downButton = createArrowButton(
                ARROW_DOWN_NORMAL_ICON,
                ARROW_DOWN_HOVER_ICON,
                ARROW_DOWN_PRESSED_ICON,
                ARROW_DOWN_BLOCKED_ICON
        );

        upButton.addActionListener(e -> scrollUp());
        downButton.addActionListener(e -> scrollDown());

        foundCardsListPanel = createFoundCardsListPanel();

        initComponents();

        upButton.setEnabled(false);
        downButton.setEnabled(false);
    }

    private void initComponents() {
        add(Box.createVerticalGlue());

        add(upButton);
        add(Box.createVerticalStrut(8));

        add(foundCardsListPanel);

        add(Box.createVerticalStrut(8));
        add(downButton);

        add(Box.createVerticalGlue());
    }

    private JButton createArrowButton(String normalPath, String hoverPath, String pressedPath, String blockedPath) {
        JButton button = new JButton();

        button.setIcon(loadScaledIcon(normalPath, ARROW_WIDTH, ARROW_HEIGHT));
        button.setRolloverIcon(loadScaledIcon(hoverPath, ARROW_WIDTH, ARROW_HEIGHT));
        button.setPressedIcon(loadScaledIcon(pressedPath, ARROW_WIDTH, ARROW_HEIGHT));
        button.setDisabledIcon(loadScaledIcon(blockedPath, ARROW_WIDTH, ARROW_HEIGHT));

        button.setRolloverEnabled(true);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(ARROW_WIDTH, ARROW_HEIGHT));
        button.setMaximumSize(new Dimension(ARROW_WIDTH, ARROW_HEIGHT));

        return button;
    }

    private JPanel createFoundCardsListPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension preferredSize = new Dimension(220, 560);
        Dimension minimumSize = new Dimension(220, FOUND_CARD_ROW_HEIGHT);
        Dimension maximumSize = new Dimension(220, Integer.MAX_VALUE);

        panel.setPreferredSize(preferredSize);
        panel.setMinimumSize(minimumSize);
        panel.setMaximumSize(maximumSize);

        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                refreshVisibleCards();
            }
        });

        return panel;
    }

    private void refreshVisibleCards() {
        foundCardsListPanel.removeAll();

        int maxVisibleCards = getMaxVisibleCards();

        int maxStartIndex = Math.max(0, foundCardImagePaths.size() - maxVisibleCards);
        if (firstVisibleCardIndex > maxStartIndex) {
            firstVisibleCardIndex = maxStartIndex;
        }

        int endIndex = Math.min(
                firstVisibleCardIndex + maxVisibleCards,
                foundCardImagePaths.size()
        );

        int visibleCount = endIndex - firstVisibleCardIndex;

        int contentHeight = visibleCount * FOUND_CARD_ROW_HEIGHT;
        int extraHeight = Math.max(0, foundCardsListPanel.getHeight() - contentHeight);

        foundCardsListPanel.add(Box.createVerticalStrut(extraHeight / 2));

        for (int i = firstVisibleCardIndex; i < endIndex; i++) {
            String imagePath = foundCardImagePaths.get(i);
            JPanel cardRow = createFoundCardRow(imagePath);
            foundCardsListPanel.add(cardRow);
        }

        foundCardsListPanel.add(Box.createVerticalStrut(extraHeight - extraHeight / 2));

        updateArrowButtons();

        foundCardsListPanel.revalidate();
        foundCardsListPanel.repaint();
    }

    private void updateArrowButtons() {
        int maxVisibleCards = getMaxVisibleCards();

        upButton.setEnabled(firstVisibleCardIndex > 0);

        downButton.setEnabled(
                firstVisibleCardIndex + maxVisibleCards < foundCardImagePaths.size()
        );
    }

    private Icon loadScaledIcon(String path, int width, int height) {
        Image image = ImageLoader.loadImage(path);
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    public void addFoundCard(String imagePath) {
        foundCardImagePaths.add(0, imagePath);
        firstVisibleCardIndex = 0;

        refreshVisibleCards();
    }

    private JButton createFoundCardButton(String imagePath) {
        JButton button = new JButton();

        button.setIcon(loadScaledIcon(imagePath, FOUND_CARD_SIZE, FOUND_CARD_SIZE));

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Dimension size = new Dimension(FOUND_CARD_SIZE, FOUND_CARD_SIZE);
        button.setPreferredSize(size);
        button.setMinimumSize(size);
        button.setMaximumSize(size);

        button.addActionListener(e -> {
            if (foundCardClickListener != null) {
                foundCardClickListener.accept(imagePath);
            }
        });

        return button;
    }

    public void clearFoundCards() {
        foundCardImagePaths.clear();
        firstVisibleCardIndex = 0;

        refreshVisibleCards();
    }

    private JPanel createFoundCardRow(String imagePath) {
        JPanel row = new JPanel();
        row.setOpaque(false);
        row.setLayout(new BoxLayout(row, BoxLayout.Y_AXIS));
        row.setAlignmentX(Component.CENTER_ALIGNMENT);

        row.setPreferredSize(new Dimension(FOUND_CARD_SIZE, FOUND_CARD_ROW_HEIGHT));
        row.setMinimumSize(new Dimension(FOUND_CARD_SIZE, FOUND_CARD_ROW_HEIGHT));
        row.setMaximumSize(new Dimension(FOUND_CARD_SIZE, FOUND_CARD_ROW_HEIGHT));

        JButton cardButton = createFoundCardButton(imagePath);

        row.add(cardButton);
        row.add(Box.createVerticalStrut(FOUND_CARD_GAP));

        return row;
    }

    private int getMaxVisibleCards() {
        int availableHeight = foundCardsListPanel.getHeight();

        if (availableHeight <= 0) {
            availableHeight = foundCardsListPanel.getPreferredSize().height;
        }

        return Math.max(1, availableHeight / FOUND_CARD_ROW_HEIGHT);
    }

    private void scrollUp() {
        if (firstVisibleCardIndex > 0) {
            firstVisibleCardIndex--;
            refreshVisibleCards();
        }
    }

    private void scrollDown() {
        int maxVisibleCards = getMaxVisibleCards();

        if (firstVisibleCardIndex + maxVisibleCards < foundCardImagePaths.size()) {
            firstVisibleCardIndex++;
            refreshVisibleCards();
        }
    }

    public void setFoundCardClickListener(Consumer<String> listener) {
        this.foundCardClickListener = listener;
    }
}