import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bai45 extends JFrame {

    private JCheckBox showImageCheckBox;
    private JLabel imageLabel;

    public bai45 () {
        setTitle("Bật/tắt hình ảnh với JCheckBox");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Tạo checkbox
        showImageCheckBox = new JCheckBox("Show Image");

        // Tạo label chứa hình
        ImageIcon icon = new ImageIcon("download.jpg"); // <-- tên ảnh bạn vừa thêm
        imageLabel = new JLabel(icon);
        imageLabel.setVisible(false); // ẩn ảnh lúc đầu

        // Thêm sự kiện cho checkbox
        showImageCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imageLabel.setVisible(showImageCheckBox.isSelected());
            }
        });

        // Thêm vào frame
        add(showImageCheckBox);
        add(imageLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new bai45();
    }
}
