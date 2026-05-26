package pl.pjatk.s36691.gui.zad58.view;

import pl.pjatk.s36691.gui.zad58.util.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends VerticalFiveSlicePanel {

    private static final Color MAIN_FONT_COLOR = new Color(210, 150, 30);
    private static final Color PLAYER_ONE_COLOR = new Color(5, 100, 100);
    private static final Color PLAYER_TWO_COLOR = new Color(160, 10, 10);

    private static final String RADIO_UNCHECKED_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/radio_button_unchecked.png";
    private static final String RADIO_CHECKED_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/radio_button_checked.png";

    private static final String BUTTON_NORMAL_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/button_normal.png";
    private static final String BUTTON_PRESSED_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/button_pressed.png";
    private static final String BUTTON_HOVER_ICON =
            "/pl/pjatk/s36691/gui/zad58/assets/ui/button_hover.png";

    private final Icon radioUncheckedIcon;
    private final Icon radioCheckedIcon;

    private final Icon buttonPressedIcon;
    private final Icon buttonHoverIcon;
    private final Icon buttonNormalIcon;

    private final JLabel playerOneScoreLabel;
    private final JLabel playerOneTimeLabel;

    private final JLabel playerTwoScoreLabel;
    private final JLabel playerTwoTimeLabel;

    private final JRadioButton onePlayerButton;
    private final JRadioButton twoPlayersButton;

    private final JRadioButton easyButton;
    private final JRadioButton mediumButton;
    private final JRadioButton hardButton;

    private final JButton startButton;
    private final JButton resetButton;

    public MenuPanel(Image backgroundImage, Font labelFont, Font buttonFont) {
        super(backgroundImage);

        setPreferredSize(new Dimension(260, 0));
        setMinimumSize(new Dimension(220, 0));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(24, 16, 24, 16));

        radioUncheckedIcon = loadScaledIcon(RADIO_UNCHECKED_ICON, 24, 24);
        radioCheckedIcon = loadScaledIcon(RADIO_CHECKED_ICON, 24, 24);

        buttonNormalIcon = loadScaledIcon(BUTTON_NORMAL_ICON, 160, 48);
        buttonPressedIcon = loadScaledIcon(BUTTON_PRESSED_ICON, 160, 48);
        buttonHoverIcon = loadScaledIcon(BUTTON_HOVER_ICON, 160, 48);

        playerOneScoreLabel = createInfoLabel("Score: 0", labelFont, PLAYER_ONE_COLOR);
        playerOneTimeLabel = createInfoLabel("Time: 10:00", labelFont, PLAYER_ONE_COLOR);

        playerTwoScoreLabel = createInfoLabel("Score: 0", labelFont, PLAYER_TWO_COLOR);
        playerTwoTimeLabel = createInfoLabel("Time: 10:00", labelFont, PLAYER_TWO_COLOR);

        onePlayerButton = createRadioButton("1 Player", labelFont);
        twoPlayersButton = createRadioButton("2 Players", labelFont);

        easyButton = createRadioButton("Easy", labelFont);
        mediumButton = createRadioButton("Medium   ", labelFont);
        hardButton = createRadioButton("Hard", labelFont);

        startButton = createMenuButton("START", buttonFont);
        resetButton = createMenuButton("RESET", buttonFont);

        initComponents(labelFont);
    }

    private void initComponents(Font labelFont) {
        add(Box.createVerticalGlue());

        add(createPlayersInfoPanel(labelFont));

        add(Box.createVerticalGlue());

        add(createBottomControlsPanel(labelFont));
    }

    private JPanel createPlayersInfoPanel(Font labelFont) {
        JPanel panel = createTransparentPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(createPlayerPanel(
                "PLAYER 1",
                playerOneScoreLabel,
                playerOneTimeLabel,
                labelFont,
                PLAYER_ONE_COLOR
        ));
        panel.add(Box.createVerticalStrut(36));
        panel.add(createPlayerPanel(
                "PLAYER 2",
                playerTwoScoreLabel,
                playerTwoTimeLabel,
                labelFont,
                PLAYER_TWO_COLOR
        ));

        return panel;
    }

    private JPanel createPlayerPanel(String title, JLabel scoreLabel, JLabel timeLabel, Font font, Color color) {
        JPanel panel = createTransparentPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = createSectionTitle(title, font, color);

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(6));
        panel.add(scoreLabel);
        panel.add(Box.createVerticalStrut(4));
        panel.add(timeLabel);

        return panel;
    }

    private JPanel createBottomControlsPanel(Font labelFont) {
        JPanel panel = createTransparentPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(createPlayersChoicePanel(labelFont));
        panel.add(Box.createVerticalStrut(18));

        panel.add(createDifficultyPanel(labelFont));
        panel.add(Box.createVerticalStrut(24));

        panel.add(startButton);
        panel.add(Box.createVerticalStrut(12));
        panel.add(resetButton);

        return panel;
    }

    private JPanel createPlayersChoicePanel(Font font) {
        JPanel panel = createTransparentPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = createSectionTitle("PLAYERS", font, MAIN_FONT_COLOR);

        ButtonGroup playersGroup = new ButtonGroup();
        playersGroup.add(onePlayerButton);
        playersGroup.add(twoPlayersButton);

        onePlayerButton.setSelected(true);

        JPanel radioRow = createRadioPanel();
        radioRow.add(onePlayerButton);
        radioRow.add(twoPlayersButton);

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(6));
        panel.add(radioRow);

        return panel;
    }

    private JPanel createDifficultyPanel(Font font) {
        JPanel panel = createTransparentPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = createSectionTitle("DIFFICULTY", font, MAIN_FONT_COLOR);

        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easyButton);
        difficultyGroup.add(mediumButton);
        difficultyGroup.add(hardButton);

        easyButton.setSelected(true);

        JPanel radioRow = createRadioPanel();
        radioRow.add(easyButton);
        radioRow.add(mediumButton);
        radioRow.add(hardButton);

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(6));
        panel.add(radioRow);

        return panel;
    }

    private JPanel createTransparentPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return panel;
    }

    private JLabel createSectionTitle(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font.deriveFont(Font.PLAIN, 18f));
        label.setForeground(color);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private JLabel createInfoLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font.deriveFont(Font.PLAIN, 14f));
        label.setForeground(color);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    private Icon loadScaledIcon(String path, int width, int height) {
        Image image = ImageLoader.loadImage(path);
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

    private JRadioButton createRadioButton(String text, Font font) {
        JRadioButton button = new JRadioButton(text);

        button.setFont(font.deriveFont(Font.PLAIN, 13f));
        button.setForeground(MAIN_FONT_COLOR);

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setIcon(radioUncheckedIcon);
        button.setSelectedIcon(radioCheckedIcon);

        button.setIconTextGap(8);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        return button;
    }

    private JPanel createRadioPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        return panel;
    }

    private JButton createMenuButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setForeground(MAIN_FONT_COLOR);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setFont(font.deriveFont(Font.PLAIN, 13f));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setIcon(buttonNormalIcon);
        button.setPressedIcon(buttonPressedIcon);
        button.setRolloverIcon(buttonHoverIcon);

        button.setRolloverEnabled(true);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(false);

        button.setMaximumSize(new Dimension(160, 48));
        return button;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public int getSelectedPlayerCount() {
        if (twoPlayersButton.isSelected()) {
            return 2;
        }

        return 1;
    }

    public String getSelectedDifficulty() {
        if (mediumButton.isSelected()) {
            return "MEDIUM";
        }

        if (hardButton.isSelected()) {
            return "HARD";
        }

        return "EASY";
    }

    public void updatePlayerOneScore(int score) {
        playerOneScoreLabel.setText("Score: " + score);
    }

    public void updatePlayerTwoScore(int score) {
        playerTwoScoreLabel.setText("Score: " + score);
    }

    public void updatePlayerOneTime(String time) {
        playerOneTimeLabel.setText("Time: " + time);
    }

    public void updatePlayerTwoTime(String time) {
        playerTwoTimeLabel.setText("Time: " + time);
    }
}
