package Control;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageController {
    
    public void ImageResizer(String sumberImage, JLabel jlabel) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(sumberImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int lebar = jlabel.getWidth() > jlabel.getHeight() ? jlabel.getHeight() : jlabel.getWidth();
        Image dimg = img.getScaledInstance(lebar, lebar, Image.SCALE_SMOOTH);
        
        ImageIcon imageIcon = new ImageIcon(dimg);
        jlabel.setIcon(imageIcon);
    }
    
    public void backgroundEntered(JPanel jpanel) {
        jpanel.setBackground(new Color(245,141,63));
    }
    
    public void backgroundExited(JPanel jpanel) {
        jpanel.setBackground(new Color(25,150,202));
    }
    
    public void panelBackgroundEntered(JPanel jpanel, JPanel jpanel2, JLabel jlabel) {
        jpanel.setBackground(new Color(245,141,63));
        jpanel2.setBackground(new Color(255, 255, 255));
        jlabel.setForeground(new Color(255, 255, 255));
    }
    
    public void panelBackgroundExited(JPanel jpanel, JPanel jpanel2, JLabel jlabel) {
        jpanel.setBackground(new Color(255, 255, 255));
        jpanel2.setBackground(new Color(25,150,202));
        jlabel.setForeground(new Color(25,150,202));
    }
    
    public void panelKategoriBackgroundEntered(JPanel jpanel, JLabel jlabel) {
        jpanel.setBackground(new Color(245,141,63));
        jlabel.setForeground(new Color(255, 255, 255));
    }
    
    public void panelKategoriBackgroundExited(JPanel jpanel, JLabel jlabel) {
        jpanel.setBackground(new Color(255, 255, 255));
        jlabel.setForeground(new Color(25,150,202));
    }
    
}
