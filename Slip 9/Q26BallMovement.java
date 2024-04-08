// Write a Java program to create a thread for moving a ball inside a panel vertically. The ball should be created when the user clicks on the start button

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q26BallMovement extends JFrame {
    private JPanel panel;
    private JButton startButton;
    private BallThread ballThread;

    private int ballY = 0; // Move ballY declaration outside the anonymous class

    public Q26BallMovement() {
        setTitle("Ball Movement");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillOval(175, ballY, 50, 50); // Draw the ball at fixed x-coordinate and variable y-coordinate
            }
        };

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveBall(); // Start moving the ball when start button is clicked
            }
        });

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(startButton, BorderLayout.SOUTH);
    }

    // Method to start moving the ball vertically
    private void moveBall() {
        if (ballThread == null || !ballThread.isAlive()) {
            ballThread = new BallThread();
            ballThread.start();
        }
    }

    // Method to stop moving the ball
    @SuppressWarnings("unused")
    private void stopBall() {
        if (ballThread != null) {
            ballThread.interrupt();
        }
    }

    // Inner class representing the thread for moving the ball vertically
    private class BallThread extends Thread {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                panel.repaint(); // Repaint the panel to update the ball's position
                try {
                    sleep(100); // Sleep for a short duration to control the speed of the ball
                    ballY += 5; // Move the ball down by 5 pixels
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Re-interrupt the thread
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Q26BallMovement().setVisible(true);
            }
        });
    }
}
