package baitapnopcasszom;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class baitapnop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField hoTenField;
	private JTextField ngaySinhField;
	private JTextField queQuanField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					baitapnop frame = new baitapnop();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public baitapnop () {
		setTitle("Student Form Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Họ và tên");
		
		JLabel lblNewLabel_1 = new JLabel("Ngày sinh");
		
		JLabel lblNewLabel_2 = new JLabel("Quê quán");
		
		hoTenField = new JTextField();
		hoTenField.setColumns(10);
		
		ngaySinhField = new JTextField();
		ngaySinhField.setColumns(10);
		
		queQuanField = new JTextField();
		queQuanField.setColumns(10);
		
		JButton themButton = new JButton("Thêm");
		themButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lấy dữ liệu từ các trường nhập
			    String hoTen = hoTenField.getText();
			    String ngaySinh = ngaySinhField.getText();
			    String queQuan = queQuanField.getText();

			    // Thêm dữ liệu vào JTable
			    DefaultTableModel model = (DefaultTableModel) table.getModel();
			    model.addRow(new Object[]{hoTen, ngaySinh, queQuan});

			    // Xóa các trường nhập sau khi thêm
			    hoTenField.setText("");
			    ngaySinhField.setText("");
			    queQuanField.setText("");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(59)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addGap(44))
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(themButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(queQuanField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
								.addComponent(ngaySinhField, 251, 251, 251)
								.addComponent(hoTenField, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
							.addGap(76))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(hoTenField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ngaySinhField))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(queQuanField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(themButton)
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"H\u1ECD v\u00E0 t\u00EAn", "Ng\u00E0y sinh", "Qu\u00EA qu\u00E1n"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
