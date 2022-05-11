package weather;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TemperatureSign extends JComponent {

    private double temperature;
    private static final int CAR_WIDTH = 20;
    private static final int CAR_HEIGHT = 60;
    private double angle = 0;

    public TemperatureSign() {
        setPreferredSize(new Dimension(400,400));
    }

    @Override
    protected void paintComponent(Graphics g1) {
        super.paintComponent(g1);

        Graphics2D g = (Graphics2D) g1;

        if (temperature > 50) {
            g.setColor(Color.RED);
        }
        else {
            g.setColor(Color.BLUE);
        }

        int width = getWidth();
        int height = getHeight();

        g.drawLine(0,0, width, height);
        g.drawLine(0, height, width, 0);

        g.drawOval(0, 0, width, height);

        g.setColor(Color.RED);

        // this moves the origin
        g.translate(width / 2, height / 2);
        g.rotate(Math.toRadians(angle));
        angle += 0.1;

        g.fillRect(-CAR_WIDTH / 2,
                -CAR_HEIGHT / 2,
                CAR_WIDTH,
                CAR_HEIGHT);

        repaint();
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        repaint();
    }
}
