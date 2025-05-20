package baitapcasllzoom1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;

public class BaitapClassroom1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BaitapClassroom1 frame = new BaitapClassroom1();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public BaitapClassroom1() {
        setTitle("My First Classroom App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout());

        // Example component
        JLabel label = new JLabel("Welcome to the classroom!");
        contentPane.add(label, BorderLayout.CENTER);

        setContentPane(contentPane);
    }
}
