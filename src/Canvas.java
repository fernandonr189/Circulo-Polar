import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Canvas extends JFrame {

    private final JPanel panel;
    private final BufferedImage buffer;

    public Canvas() {
        setTitle("CirculoPolar");
        setSize(600, 600);
        panel = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setSize(600, 600);
        setLocationRelativeTo(null);
        buffer = new BufferedImage(panel.getWidth(),panel.getHeight(),BufferedImage.TYPE_INT_ARGB);
        add(panel);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        circuloPolar(300, 300, 180, Color.red);
        getGraphics().drawImage(buffer,0,0,panel);
    }

    public void circuloPolar(int xc, int yc, int r, Color a){
        int angler;
        int angle;
        int x;
        int y;
        for (angle = 0; angle < 360; angle ++){
            angler=(int)((angle * 180)/Math.PI);
            x = (int) (xc + (r*cos(angler)));
            y = (int) (yc + (r*sin(angler)));
            pixel(x, y, a);
        }
    }

    private void pixel(int x, int y, Color a) {
        buffer.setRGB(x, y, a.getRGB());
    }
}
