package pl.pjatk.s36691.gui.zad55;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {

        MyListModel model = new MyListModel();
        JList<String> list = new JList<>();
        MyListCellRenderer renderer = new MyListCellRenderer();

        list.setModel(model);
        list.setCellRenderer(renderer);
        add(new JScrollPane(list));

        setTitle("Temperatura C/F");
        setSize(240, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
