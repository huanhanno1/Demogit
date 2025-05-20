import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableApp {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("JTable Example");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Dữ liệu cho bảng
        String[][] data = {
            {"1", "Nguyễn Văn A", "20"},
            {"2", "Trần Thị B", "21"},
            {"3", "Lê Văn C", "19"}
        };

        // Tên cột
        String[] columnNames = {"ID", "Tên", "Tuổi"};

        // Tạo bảng JTable
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // Thêm bảng vào frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Hiển thị frame
        frame.setVisible(true);
    }
}
