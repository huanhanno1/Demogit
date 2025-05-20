import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.*;

public class bai48 extends JFrame {
    private JTextField textField;
    private JLabel displayLabel;

    public bai48() {
        setTitle("Chỉ Nhập Số");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Number: ");
        add(label);

        textField = new JTextField(10);
        add(textField);

        displayLabel = new JLabel();
        add(displayLabel);

        // Gắn DocumentListener để theo dõi thay đổi văn bản
        Document doc = textField.getDocument();
        doc.addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateLabel();
            }

            public void removeUpdate(DocumentEvent e) {
                updateLabel();
            }

            public void changedUpdate(DocumentEvent e) {
                updateLabel();
            }
        });

        setVisible(true);
    }

    private void updateLabel() {
        String text = textField.getText();
        if (text.matches("\\d*")) {
            displayLabel.setText("Số: " + text);
        } else {
            // Nếu có ký tự không phải số → xóa hoặc báo lỗi
            SwingUtilities.invokeLater(() -> {
                textField.setText(text.replaceAll("[^\\d]", ""));
            });
        }
    }

    public static void main(String[] args) {
        new bai48();
    }
}
