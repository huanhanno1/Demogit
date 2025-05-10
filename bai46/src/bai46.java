import javax.swing.*;
import java.awt.event.*;

public class bai46 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hiển thị mục chọn từ JList");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        String[] items = {
            "Mục 1", "Mục 2", "Mục 3", "Mục 4", "Mục 5",
            "Mục 6", "Mục 7", "Mục 8", "Mục 9", "Mục 10"
        };
        JList<String> itemList = new JList<>(items);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(itemList);
        frame.add(scrollPane);

        itemList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = itemList.locationToIndex(e.getPoint());
                    String selectedItem = itemList.getModel().getElementAt(index);
                    JOptionPane.showMessageDialog(frame, "Bạn đã chọn: " + selectedItem);
                }
            }
        });

        frame.setVisible(true);
    }
}
