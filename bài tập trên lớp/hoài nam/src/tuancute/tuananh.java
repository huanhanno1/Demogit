package tuancute;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class tuananh extends JFrame {
    private JCheckBox enableBgCheckBox;
    private Color defaultBgColor;

    public tuananh () {
        // Thiết lập tiêu đề và kích thước cửa sổ
        super("JCheckBox Background Demo");
        getContentPane().setBackground(new Color(255, 255, 128));
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Lưu màu nền mặc định
        defaultBgColor = getContentPane().getBackground();

        // Tạo JCheckBox và thêm vào frame
        enableBgCheckBox = new JCheckBox("Enable Background");
        enableBgCheckBox.setBackground(new Color(255, 255, 128));
        enableBgCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Nếu được chọn, đặt nền thành xanh; nếu bỏ chọn, trả về màu mặc định
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    getContentPane().setBackground(Color.GREEN);
                } else {
                    getContentPane().setBackground(defaultBgColor);
                }
                // Cập nhật lại giao diện
                repaint();
            }
        });

        // Đưa checkbox vào phía trên (North) của layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(enableBgCheckBox, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        // Khởi chạy giao diện trong Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            tuananh demo = new tuananh ();
            demo.setVisible(true);
        });
    }
}
