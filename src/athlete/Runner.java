package athlete;

import movement.Speed;
import ui.Stadium;

import java.awt.*;

public class Runner {

    /** the x coordinate of the lower left corner */
    int x = 0;
    /** the y coordinate of the lower left corner */
    int y = 435;
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
        x += speed.getIncrement();
    }

    public void start(){
        started = true;
    }

    public boolean canRun(){
        return started && x + width < 950;
    }
    public boolean finished(){
        return x + width >= 950;
    }
}
