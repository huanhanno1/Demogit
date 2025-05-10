import javax.swing.*;
import java.awt.event.*;

public class bai43 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Thông báo khi đóng cửa sổ");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Không tự động đóng

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure?",
                    "Xác nhận đóng",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                
                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose(); // Đóng cửa sổ
                }
                // Nếu chọn No thì không làm gì cả
            }
        });

        frame.setVisible(true);
    }
}
