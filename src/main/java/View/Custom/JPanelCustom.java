package View.Custom;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


public class JPanelCustom extends JPanel {

    public int getRadiusTopLeft() {
        return radiusTopLeft;
    }

    public void setRadiusTopLeft(int radiusTopLeft) {
        this.radiusTopLeft = radiusTopLeft;
        repaint();
    }

    public int getRadiusTopRight() {
        return radiusTopRight;
    }

    public void setRadiusTopRight(int radiusTopRight) {
        this.radiusTopRight = radiusTopRight;
        repaint();
    }

    public int getRadiusBottomLeft() {
        return radiusBottomLeft;
    }

    public void setRadiusBottomLeft(int radiusBottomLeft) {
        this.radiusBottomLeft = radiusBottomLeft;
        repaint();
    }

    public int getRadiusBottomRight() {
        return radiusBottomRight;
    }

    public void setRadiusBottomRight(int radiusBottomRight) {
        this.radiusBottomRight = radiusBottomRight;
        repaint();
    }
    
    
    
    
    
    private int radiusTopLeft = 0;
    private int radiusTopRight = 0;
    private int radiusBottomLeft = 0;
    private int radiusBottomRight = 0;
    
    public JPanelCustom() {
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, 
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        
        g2.setColor(getBackground());
        
        Area area = new Area(createRadiusTopLeft());
        
        if (radiusTopRight > 0) {
            area.intersect(new Area(createRadiusTopRight()));
        }
        
        if (radiusBottomLeft > 0) {
            area.intersect(new Area(createRadiusBottomLeft()));
        }
        
        if (radiusBottomRight > 0) {
            area.intersect(new Area(createRadiusBottomRight()));
        }
        
        g2.fill(area);
        g2.dispose();
        
        super.paintComponent(g);
    }
    
    
    private Shape createRadiusTopLeft() {
        int width = getWidth();
        int height = getHeight();
    
        int roundX = Math.min(width, radiusTopLeft);
        int roundY = Math.min(height, radiusTopLeft);
        
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRadiusTopRight() {
        int width = getWidth();
        int height = getHeight();
    
        int roundX = Math.min(width, radiusTopRight);
        int roundY = Math.min(height, radiusTopRight);
        
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }
    
    
    private Shape createRadiusBottomLeft() {
        int width = getWidth();
        int height = getHeight();
    
        int roundX = Math.min(width, radiusBottomLeft);
        int roundY = Math.min(height, radiusBottomLeft);
        
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    
    private Shape createRadiusBottomRight() {
        int width = getWidth();
        int height = getHeight();
    
        int roundX = Math.min(width, radiusBottomRight);
        int roundY = Math.min(height, radiusBottomRight);
        
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
    
    
}
