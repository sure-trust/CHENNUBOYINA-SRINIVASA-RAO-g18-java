import java.awt.*;
import javax.swing.*;

class IndianFlag extends Canvas {
    public void paint(Graphics g) {
        // Draw the Saffron Rectangle
        g.setColor(new Color(255, 153, 51)); // Saffron color
        g.fillRect(50, 50, 300, 50);

        // Draw the White Rectangle
        g.setColor(Color.WHITE);
        g.fillRect(50, 100, 300, 50);

        // Draw the Green Rectangle
        g.setColor(new Color(19, 136, 8)); // Green color
        g.fillRect(50, 150, 300, 50);

        // Draw the Ashoka Chakra (Blue Circle)
        g.setColor(new Color(0, 0, 128)); // Navy blue color
        int chakraX = 175, chakraY = 100, chakraDiameter = 50;
        g.drawOval(chakraX, chakraY, chakraDiameter, chakraDiameter); // Outer circle

        // Draw 24 spokes of Ashoka Chakra
        double angleStep = Math.toRadians(360 / 24); // 24 spokes
        int centerX = chakraX + chakraDiameter / 2;
        int centerY = chakraY + chakraDiameter / 2;
        int radiusOuter = chakraDiameter / 2;
        int radiusInner = 5; // Small inner circle

        // Draw inner circle
        g.fillOval(centerX - radiusInner, centerY - radiusInner, 2 * radiusInner, 2 * radiusInner);

        // Draw 24 spokes
        for (int i = 0; i < 24; i++) {
            double angle = i * angleStep;
            int x1 = centerX + (int) (radiusInner * Math.cos(angle));
            int y1 = centerY + (int) (radiusInner * Math.sin(angle));
            int x2 = centerX + (int) (radiusOuter * Math.cos(angle));
            int y2 = centerY + (int) (radiusOuter * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) {
        Frame f = new Frame("Indian Flag with Ashoka Chakra");
        IndianFlag flag = new IndianFlag();
        
        f.add(flag);
        f.setSize(400, 300);
        f.setVisible(true);
        
        // Close on window exit
        f.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
