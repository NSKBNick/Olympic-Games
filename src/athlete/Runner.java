package athlete;

import movement.Speed;
import ui.Stadium;

import java.awt.*;

public class Runner {
    public static final int SPEED_FACTOR = 10;
    /** the x coordinate of the lower left corner */
    int x = 0;
    /** the y coordinate of the lower left corner */
    int y = 60;
    int width = 10;
    int height = 10;
    public Speed speed = new Speed();
    boolean started = false;
    public Runner(){

    }

    public void drawRunner(Graphics2D g2d, Stadium pane){
        updateXCoordinate();
        System.out.println(x);
        g2d.drawRect(pane.scaleX(x),pane.scaleY(y),pane.scaleX(width),pane.scaleY(height));
    }
    private void updateXCoordinate(){
        x += (int)(speed.getClicks() * SPEED_FACTOR);
    }

    public void start(){
        this.started = true;
    }


    public boolean canRun(){
        return started && x + width < 950;
    }
    public boolean finished(){
        return x + width >= 950;
    }
}
