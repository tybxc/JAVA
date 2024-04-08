// Write a java program to scroll the text from left to right continuously

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q215TextScrolling extends JFrame {
    private JLabel label;

    public Q215TextScrolling() {
        setTitle("Text Scrolling");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a label with scrolling text
        label = new JLabel("This is a scrolling text.      "); // Add extra spaces to make the scrolling visible
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        // Create a timer to scroll the text
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = label.getText();
                text = text.charAt(text.length() - 1) + text.substring(0, text.length() - 1);
                label.setText(text);
            }
        });
        timer.start();

        getContentPane().add(label, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Q215TextScrolling().setVisible(true);
            }
        });
    }
}
