package pl.pjatk.s36691.gui.zad54;

import javax.swing.*;
import java.util.List;

public class MyJListFrame extends JFrame {


    public MyJListFrame(List<String> list) {

        DefaultListModel<String> model = new DefaultListModel<>();
        list.forEach(model::addElement);

        JList<String> listComponent = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(listComponent);
        add(scrollPane);

        setTitle("Solar System List");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
