import javax.swing.*;
import java.awt.event.*;

public class bai41 {
    public bai41 () {
        JFrame frame = new JFrame("Mở JDialog khi nhấn nút");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton button = new JButton("Open Dialog");
        button.setBounds(130, 100, 140, 40);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(frame, "Dialog", true);
                dialog.setSize(200, 150);
                dialog.setLayout(null);

                JLabel label = new JLabel("Dialog Opened");
                label.setBounds(50, 50, 100, 30);

                dialog.add(label);
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });

        frame.add(button);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new bai41 ();
    }
}
