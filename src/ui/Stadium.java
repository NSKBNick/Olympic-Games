package ui;



import athlete.Runner;
import movement.EventHandler;
import stage.Start;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Stadium extends JPanel {
    Runner runner = new Runner();
    Start start = new Start(this);
    long startingTime = 0;
    long finishingTime = 0;

    public Stadium() {
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
        g.fillRect(0, 0, scaleX(1000), scaleY(1000));
        g2d.setColor(Color.RED);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Stroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
        g2d.setStroke(stroke);
        for (int y = 125; y <= 875; y += 125) {
            g2d.draw(new Line2D.Double(0, scaleY(y), scaleX(900), scaleY(y)));
        }
        runner.drawRunner(g2d, this);
        if (start.getDisplayText() != null) {
            g.setFont(new Font("Arial", Font.PLAIN, 100));
            g.setColor(Color.GREEN);
            g2d.drawString(start.getDisplayText(), scaleX(450), scaleY(500));
        }
        if (runner.finished()) {
             finishingTime = (System.currentTimeMillis() - startingTime)/1000;
            drawTime(g, g2d, finishingTime);
        } else if (runner.canRun()){
            drawTime(g, g2d, (System.currentTimeMillis() - startingTime)/1000);
            try {
                Thread.sleep(10);
                repaint();
            } catch(InterruptedException e ){
                // no action
            }
        }
    }

    private void drawTime(Graphics g, Graphics2D g2d, long time) {
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.setColor(Color.GREEN);
        g2d.drawString(Long.toString(time), scaleX(450), scaleY(100));

    }


    public int scaleX(int x) {
        int panelWidth = getWidth();
        //System.out.println("width:"+panelWidth);
        return x * panelWidth / 1000;
    }

    public int scaleY(int y) {
        int panelHeight = getHeight();
        //System.out.println("Height:"+panelHeight);
        return y * panelHeight / 1000;
    }

    public void start() {
        Thread thread = new Thread(start);
        thread.start();
    }

    public void startRunning() {
        startingTime = System.currentTimeMillis();
        runner.start();

    }
}