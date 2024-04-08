// Write a Java program using Runnable interface to blink Text on the frame.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q22BlinkingText implements Runnable {
    private JLabel label;
    private boolean isBlinking;

    public Q22BlinkingText(JLabel label) {
        this.label = label;
        this.isBlinking = true;
    }

    @Override
    public void run() {
        try {
            while (isBlinking) {
                label.setVisible(!label.isVisible()); // Toggle visibility of label
                Thread.sleep(500); // Pause for 500 milliseconds
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopBlinking() {
        isBlinking = false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Blinking Text");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Blinking Text");
        frame.add(label);

        Q22BlinkingText blinkingText = new Q22BlinkingText(label);
        Thread thread = new Thread(blinkingText);
        thread.start();

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                blinkingText.stopBlinking();
            }
        });
    }
}

