// Write a Multithreading program in java to display the number’s between 1 to 100 continuously in a TextField by clicking on button. (Use Runnable Interface).

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q210NumberDisplay extends JFrame {
    private JTextField textField;
    private JButton startButton;
    private NumberPrinter numberPrinter;

    public Q210NumberDisplay() {
        setTitle("Number Display");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        textField = new JTextField(20);
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberPrinter == null || !numberPrinter.isRunning()) {
                    numberPrinter = new NumberPrinter();
                    Thread thread = new Thread(numberPrinter);
                    thread.start();
                }
            }
        });

        add(textField);
        add(startButton);
    }

    private class NumberPrinter implements Runnable {
        private volatile boolean running = true;

        @Override
        public void run() {
            for (int i = 1; i <= 100 && running; i++) {
                int numberToDisplay = i; // Declare a local variable that is effectively final
                try {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            textField.setText(Integer.toString(numberToDisplay));
                        }
                    });
                    Thread.sleep(1000); // Display each number for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @SuppressWarnings("unused")
        public void stop() {
            running = false;
        }

        public boolean isRunning() {
            return running;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Q210NumberDisplay().setVisible(true);
            }
        });
    }
}
