import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallMovement extends JFrame {
    private JPanel panel;
    private JButton startButton;
    private Ball ball;

    public BallMovement() {
        setTitle("Ball Movement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        panel = new JPanel();
        startButton = new JButton("Start");
        startButton.addActionListener(new StartButtonListener());

        panel.add(startButton);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class Ball extends JPanel implements Runnable {
        private int x, y;
        private final int DIAMETER = 30;
        private final int SPEED = 5;
        private volatile boolean running = true;

        public Ball() {
            x = 150;
            y = 50;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillOval(x, y, DIAMETER, DIAMETER);
        }

        @Override
        public void run() {
            while (running) {
                moveBall();
                repaint();
                try {
                    Thread.sleep(50); // Adjust the speed here
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void moveBall() {
            y += SPEED;
            if (y + DIAMETER >= getHeight()) {
                y = getHeight() - DIAMETER;
                running = false;
            }
        }
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startButton.setEnabled(false);
            panel.remove(startButton);
            ball = new Ball();
            panel.add(ball);
            Thread ballThread = new Thread(ball);
            ballThread.start();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BallMovement();
            }
        });
    }
}
