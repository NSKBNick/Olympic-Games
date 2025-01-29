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
        g2d.drawLine(0,80,2000,80);
        g2d.drawLine(0,160,2000,160);
        g2d.drawLine(0,240,2000,240);
        g2d.drawLine(0,320,2000,320);
        g2d.drawLine(0,400,2000,400);
        g2d.drawLine(0,480,2000,480);
        g2d.drawLine(0,560,2000,560);
        g2d.drawLine(0,640,2000,640);
        g2d.drawLine(0,720,2000,720);
        g2d.drawString("Start",100,100 );
    }
}