package stage;

import ui.Stadium;

public class Start implements Runnable {
    String displayText = null;
    Stadium stadium;
public Start(Stadium stadium){
 this.stadium = stadium;
}
    @Override
    public void run(){
    try {
        displayText = "3";
        stadium.repaint();
        Thread.sleep(1000);
        displayText = "2";
        stadium.repaint();
        Thread.sleep(1000);
        displayText = "1";
        stadium.repaint();
        Thread.sleep(1000);
        displayText = "Los";
        stadium.startRunning();
        stadium.repaint();
        Thread.sleep(1000);
        displayText = null;
        stadium.repaint();
    } catch(InterruptedException e ){
        // no action
    }
    }

    public String getDisplayText() {
        return displayText;
    }
}
