package weather;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class TemperatureSign extends JComponent {

    private double temperature;

    public TemperatureSign() {
        setPreferredSize(new Dimension(400,400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (temperature > 50) {
            g.setColor(Color.RED);
        }
        else {
            g.setColor(Color.BLUE);
        }
        g.drawLine(0,0, 400, 400);
        g.drawLine(0,400, 400, 0);
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        repaint();
    }
}
