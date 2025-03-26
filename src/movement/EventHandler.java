package movement;

import athlete.Runner;
import ui.Stadium;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventHandler implements KeyListener{
    int RUN_CODE = 32;
    int START_CODE = 10;
    boolean initiated = false;
    Runner runner;
    boolean keyReleased = true;

    Stadium stadium;
    public EventHandler(Runner runner, Stadium pane){
        this.runner = runner;
        this.stadium = pane;
    }
    @Override
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == RUN_CODE && runner.canRun() && keyReleased){
            runner.speed.increaseClicks();
            stadium.repaint();
            keyReleased = false;
        }  else if (e.getKeyCode() == START_CODE && !initiated) {
            stadium.start();
            initiated = true;
         }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    // Event is handled by keyPressed
    }

    @Override
    public void keyReleased(KeyEvent e) {
    keyReleased = true;
    }
}
