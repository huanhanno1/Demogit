import javax.swing.*;
import java.awt.event.*;

public class bai47 extends JFrame {
    private JLabel label;

    public bai47() { // Đúng: constructor trùng với tên class
        setTitle("Mouse Follow Example");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Follow Me");
        label.setBounds(50, 50, 100, 30);
        add(label);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                label.setLocation(e.getX(), e.getY());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new bai47(); // Gọi đúng constructor
    }
}
