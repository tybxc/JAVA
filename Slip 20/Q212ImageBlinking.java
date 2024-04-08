// Write a java program to blink image on the JFrame continuously

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("unused")
public class Q212ImageBlinking extends JFrame {
    private ImageIcon imageIcon;
    private JLabel imageLabel;

    public Q212ImageBlinking() {
        setTitle("Image Blinking");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the image
        imageIcon = new ImageIcon("image.jpg"); // Change "image.jpg" to the path of your image file
        imageLabel = new JLabel(imageIcon);

        getContentPane().add(imageLabel, BorderLayout.CENTER);

        // Create and start a thread for blinking the image
        BlinkingThread blinkingThread = new BlinkingThread();
        blinkingThread.start();
    }

    // Inner class representing the thread for blinking the image
    private class BlinkingThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    // Toggle the visibility of the image label
                    imageLabel.setVisible(!imageLabel.isVisible());
                    Thread.sleep(500); // Pause for 500 milliseconds (0.5 seconds)
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Q212ImageBlinking().setVisible(true);
            }
        });
    }
}
