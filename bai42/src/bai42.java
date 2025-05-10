import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai42 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chọn màu");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange"};
        JComboBox<String> comboBox = new JComboBox<>(colors);
        comboBox.setBounds(90, 60, 120, 30);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) comboBox.getSelectedItem();
                Color color = Color.WHITE;

                switch (selectedColor) {
                    case "Red":
                        color = Color.RED; break;
                    case "Blue":
                        color = Color.BLUE; break;
                    case "Green":
                        color = Color.GREEN; break;
                    case "Yellow":
                        color = Color.YELLOW; break;
                    case "Orange":
                        color = Color.ORANGE; break;
                }

                // Tạo panel màu để hiển thị trong JOptionPane
                JPanel colorPanel = new JPanel();
                colorPanel.setPreferredSize(new Dimension(100, 50));
                colorPanel.setBackground(color);

                JOptionPane.showMessageDialog(frame, colorPanel, "Màu bạn chọn: " + selectedColor, JOptionPane.PLAIN_MESSAGE);
            }
        });

        frame.add(comboBox);
        frame.setVisible(true);
    }
}
