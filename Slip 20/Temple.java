import javax.swing.*;
import java.awt.*;

public class TempleDrawing extends JFrame {
    public TempleDrawing() {
        setTitle("Temple Drawing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTemple(g);
    }

    private void drawTemple(Graphics g) {
        // Draw temple base
        g.setColor(Color.GRAY);
        g.fillRect(100, 200, 200, 150);

        // Draw temple roof
        int[] xPoints = {100, 200, 300};
        int[] yPoints = {200, 100, 200};
        g.setColor(Color.RED);
        g.fillPolygon(xPoints, yPoints, 3);

        // Draw door
        g.setColor(Color.WHITE);
        g.fillRect(180, 280, 40, 70);

        // Draw windows
        g.setColor(Color.YELLOW);
        g.fillRect(130, 220, 40, 40);
        g.fillRect(230, 220, 40, 40);
    }

    public static void main(String[] args) {
        TempleDrawing templeDrawing = new TempleDrawing();

        // Optional: Create a separate thread to repaint the temple after a delay
        Thread repaintThread = new Thread(() -> {
            try {
                Thread.sleep(5000); // Wait for 5 seconds
                templeDrawing.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        repaintThread.start();
    }
}
