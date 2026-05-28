package pl.pjatk.s36691.gui.zad61;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ThumbnailList extends JScrollPane {

    private final DefaultListModel<ImageIcon> thumbnailsModel;
    private final JList<ImageIcon> thumbnailsList;

    public ThumbnailList(Image[] images) {
        this.thumbnailsModel = new DefaultListModel<>();
        this.thumbnailsList = new JList<>(thumbnailsModel);

        setupModel(images);
        setupList();
        setupScrollPane();
    }

    private void setupModel(Image[] images) {
        for (Image image : images) {
            thumbnailsModel.addElement(createThumbnail(image));
        }
    }

    private void setupList() {
        thumbnailsList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        thumbnailsList.setVisibleRowCount(1);
        thumbnailsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        thumbnailsList.setFixedCellWidth(100);
        thumbnailsList.setFixedCellHeight(100);

        thumbnailsList.setBackground(new Color(20, 60, 80));
        thumbnailsList.setOpaque(true);

        thumbnailsList.setCellRenderer(new ThumbnailRenderer());

        thumbnailsList.setSelectedIndex(0);
    }

    private void setupScrollPane() {
        setViewportView(thumbnailsList);
        setPreferredSize(new Dimension(0, 120));
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        getViewport().setBackground(new Color(20, 60, 80));
        setBackground(new Color(20, 60, 80));
        setBorder(BorderFactory.createEmptyBorder());
    }

    private ImageIcon createThumbnail(Image image) {
        int thumbnailWidth = 80;
        int thumbnailHeight = 80;

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        if (imageWidth <= 0 || imageHeight <= 0) {
            return new ImageIcon(image);
        }

        double widthScale = (double) thumbnailWidth / imageWidth;
        double heightScale = (double) thumbnailHeight / imageHeight;
        double scale = Math.min(widthScale, heightScale);

        int scaledWidth = (int) (imageWidth * scale);
        int scaledHeight = (int) (imageHeight * scale);

        Image scaledImage = image.getScaledInstance(
                scaledWidth,
                scaledHeight,
                Image.SCALE_SMOOTH
        );

        return new ImageIcon(scaledImage);
    }

    public void setSelectedThumbnail(int index) {
        thumbnailsList.setSelectedIndex(index);
        thumbnailsList.ensureIndexIsVisible(index);
    }

    private static class ThumbnailRenderer extends JLabel implements ListCellRenderer<ImageIcon> {

        private static final Color BACKGROUND_COLOR = new Color(20, 60, 80);
        private static final Color SELECTED_BORDER_COLOR = Color.YELLOW;

        public ThumbnailRenderer() {
            setOpaque(true);
            setHorizontalAlignment(JLabel.CENTER);
            setVerticalAlignment(JLabel.CENTER);
        }

        @Override
        public Component getListCellRendererComponent(
                JList<? extends ImageIcon> list,
                ImageIcon value,
                int index,
                boolean isSelected,
                boolean cellHasFocus
        ) {
            setIcon(value);
            setText(null);

            setBackground(BACKGROUND_COLOR);

            if (isSelected) {
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createCompoundBorder(
                                BorderFactory.createEmptyBorder(4,4,4,4),
                                BorderFactory.createLineBorder(SELECTED_BORDER_COLOR, 4)),
                        BorderFactory.createEmptyBorder(4,4,4,4)));
            } else {
                setBorder(BorderFactory.createEmptyBorder(12,12,12,12));
            }

            return this;
        }
    }

    public void addThumbnailSelectionListener(ListSelectionListener listener) {
        thumbnailsList.addListSelectionListener(listener);
    }

    public int getSelectedIndex() {
        return thumbnailsList.getSelectedIndex();
    }
}


