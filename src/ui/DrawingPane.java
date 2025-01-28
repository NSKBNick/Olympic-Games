package ui;



import javax.swing.*;
import java.awt.*;

public class DrawingPane extends JPanel {

    public DrawingPane(){
        super();
        setLayout(new BorderLayout());
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint...");
        g.setColor(Color.BLACK);
        g.fillRect(0,0, this.getWidth(), this.getHeight() );

        g.setColor(new Color(179, 255, 255));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Stroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
        g2d.setStroke(stroke);
        g2d.drawLine(0,0,100,100);
    }
}