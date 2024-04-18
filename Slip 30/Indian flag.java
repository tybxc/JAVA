import javax.swing.*;
import java.awt.*;

public class IndianFlagDrawing extends JFrame {
    private final int flagWidth = 600;
    private final int flagHeight = 400;
    private final Color saffronColor = new Color(255, 153, 51);
    private final Color white = Color.WHITE;
    private final Color greenColor = new Color(18, 136, 7);

    public IndianFlagDrawing() {
        setTitle("Indian Flag");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(flagWidth, flagHeight);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawIndianFlag(g);
    }

    private void drawIndianFlag(Graphics g) {
        int stripeHeight = flagHeight / 3;

        // Draw saffron stripe
        g.setColor(saffronColor);
        g.fillRect(0, 0, flagWidth, stripeHeight);

        // Draw white stripe
        g.setColor(white);
        g.fillRect(0, stripeHeight, flagWidth, stripeHeight);

        // Draw green stripe
        g.setColor(greenColor);
        g.fillRect(0, 2 * stripeHeight, flagWidth, stripeHeight);

        // Draw Ashoka Chakra
        int chakraRadius = stripeHeight / 2;
        int centerX = flagWidth / 2;
        int centerY = stripeHeight / 2;
        drawChakra(g, centerX, centerY, chakraRadius);
    }

    private void drawChakra(Graphics g, int centerX, int centerY, int radius) {
        int[] chakraX = new int[24];
        int[] chakraY = new int[24];

        double angle = Math.PI / 12;
        for (int i = 0; i < 24; i++) {
            int x = centerX + (int) (radius * Math.cos(angle * i));
            int y = centerY + (int) (radius * Math.sin(angle * i));
            chakraX[i] = x;
            chakraY[i] = y;
        }

        g.setColor(white);
        g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

        g.setColor(greenColor);
        g.fillPolygon(chakraX, chakraY, 24);
        g.setColor(white);
        g.fillOval(centerX - radius / 2, centerY - radius / 2, radius, radius);
    }

    public static void main(String[] args) {
        IndianFlagDrawing flagDrawing = new IndianFlagDrawing();

        // Optional: Create a separate thread to repaint the flag after a delay
        Thread repaintThread = new Thread(() -> {
            try {
                Thread.sleep(5000); // Wait for 5 seconds
                flagDrawing.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        repaintThread.start();
    }
}
