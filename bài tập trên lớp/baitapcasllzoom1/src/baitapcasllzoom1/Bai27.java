package baitapcasllzoom1;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Bai27 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JProgressBar progressBar;
    private JButton startButton;
    private JButton pauseButton;
    private JButton resetButton;

    private Thread progressThread;
    private volatile boolean isRunning = false;
    private volatile boolean isPaused = false;
    private int currentValue = 0;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Bai27 frame = new Bai27();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Bai27() {
        setTitle("JProgressBar Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 200);

        // Màu nền vàng mặc định
        Color defaultBackgroundColor = new Color(255, 255, 153); // Vàng sáng
        Color startButtonColor = new Color(173, 216, 230); // Xanh nước biển
        Color pauseButtonColor = new Color(255, 182, 193); // Hồng nhạt
        Color buttonColor = new Color(255, 182, 193); // Trắng hồng

        contentPane = new JPanel();
        contentPane.setBackground(defaultBackgroundColor);
        contentPane.setLayout(new BorderLayout(10, 10));
        setContentPane(contentPane);

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.BLUE);
        progressBar.setBackground(Color.WHITE);
        contentPane.add(progressBar, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(defaultBackgroundColor);

        startButton = new JButton("Start");
        pauseButton = new JButton("Pause");
        resetButton = new JButton("Reset");

        // Giao diện các nút
        for (JButton btn : new JButton[]{startButton, pauseButton, resetButton}) {
            btn.setBackground(buttonColor);
            btn.setForeground(Color.BLACK);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Arial", Font.BOLD, 12));
        }

        pauseButton.setEnabled(false);
        resetButton.setEnabled(false);

        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        startButton.addActionListener((ActionEvent e) -> startProgress(startButtonColor));
        pauseButton.addActionListener((ActionEvent e) -> togglePause(pauseButtonColor));
        resetButton.addActionListener((ActionEvent e) -> resetProgress(defaultBackgroundColor));
    }

    private void startProgress(Color startButtonColor) {
        if (isRunning) return;

        isRunning = true;
        isPaused = false;
        startButton.setEnabled(false);
        pauseButton.setEnabled(true);
        resetButton.setEnabled(true);

        // Chuyển nền sang màu xanh nước biển khi bắt đầu
        contentPane.setBackground(startButtonColor);

        progressThread = new Thread(() -> {
            for (int i = currentValue; i <= 100; i++) {
                if (!isRunning) return;

                while (isPaused) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        return;
                    }
                }

                currentValue = i;

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    return;
                }

                final int value = i;
                SwingUtilities.invokeLater(() -> progressBar.setValue(value));
            }

            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(this, "Hoàn thành!");
                resetProgress(new Color(255, 255, 153)); // Quay lại màu vàng khi hoàn thành
            });
        });

        progressThread.start();
    }

    private void togglePause(Color pauseButtonColor) {
        if (!isRunning) return;

        isPaused = !isPaused;
        pauseButton.setText(isPaused ? "Resume" : "Pause");

        // Chuyển nền sang màu hồng khi tạm dừng
        contentPane.setBackground(pauseButtonColor);
    }

    private void resetProgress(Color defaultBackgroundColor) {
        if (progressThread != null && progressThread.isAlive()) {
            progressThread.interrupt();
        }

        isRunning = false;
        isPaused = false;
        currentValue = 0;

        progressBar.setValue(0);
        startButton.setText("Start");
        startButton.setEnabled(true);
        pauseButton.setText("Pause");
        pauseButton.setEnabled(false);
        resetButton.setEnabled(false);

        // Quay lại màu vàng khi reset
        contentPane.setBackground(defaultBackgroundColor);
    }
}
