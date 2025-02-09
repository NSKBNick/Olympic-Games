package ui;

import Athlete.Runner;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventHandler implements KeyListener{
    int RUN_CODE = 0;
    Runner runner;

    DrawingPane pane;
    public EventHandler(Runner runner, DrawingPane pane){
        this.runner = runner;
        this.pane = pane;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key event!");
         if(e.getKeyCode() == RUN_CODE){
            runner.speed.increaseClicks();
            pane.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    // Event is handeled by keyTyped
    }

    @Override
    public void keyReleased(KeyEvent e) {
    // Event is handeled by keyTyped
    }
}
