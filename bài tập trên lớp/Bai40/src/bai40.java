import javax.swing.*;
import java.awt.event.*;

public class bai40 {
    private int count = 0; 

    public bai40() {
        JFrame frame = new JFrame("Đếm số lần nhấn nút");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 

        JLabel label = new JLabel("Count: 0");
        label.setBounds(100, 50, 100, 30);

        JButton button = new JButton("Click Me");
        button.setBounds(90, 100, 120, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                label.setText("Count: " + count);
            }
        });

        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new bai40();
    }
}
