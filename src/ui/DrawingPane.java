package ui;



import Athlete.Runner;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DrawingPane extends JPanel {
 Runner runner = new Runner();
    public DrawingPane(){
        super();
        setLayout(new BorderLayout());
        runner.speed.reset();
    }

    public void setEventHandler(JFrame frame) {
        frame.addKeyListener(new EventHandler(runner, this));
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint...");
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D) g;
        g.fillRect(0,0,scaleX(1000),scaleY(1000));
        g2d.setColor(Color.RED);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Stroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
        g2d.setStroke(stroke);
        for(int y = 125; y <= 875; y +=125) {
            g2d.draw(new Line2D.Double(0, scaleY(y), scaleX(900), scaleY(y)));
        }
        runner.drawRunner(g2d,this);
        g2d.drawString("Start",0,0 );
    }
    public int scaleX(int x){
        int panelWidth = getWidth();
        //System.out.println("width:"+panelWidth);
        return x * panelWidth / 1000;
    }
    public int scaleY(int y){
        int panelHeight = getHeight();
        //System.out.println("Height:"+panelHeight);
        return y * panelHeight / 1000;
    }
}