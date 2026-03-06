package View.Custom;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class JLabelCustom extends JLabel {
    private int radius = 20;
    
    public JLabelCustom() {
        setOpaque(false);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        
        g2.setClip(new RoundRectangle2D.Double(
            0, 0, getWidth(), getHeight(), radius, radius
        ));
        
        super.paintComponent(g2);
        g2.dispose();
    }
}
