package movement;

public class Speed {
    int clicks = 0;
    public static final double SPEED_FACTOR = 10.5;

    public Speed(){
    }
    public void increaseClicks(){
        System.out.println("increase clicks");
        clicks ++;
    }
    public void reset(){
        clicks = 0;
    }

    public double getClicks(){
       int result = clicks;
        reset();
        return result;
    }
    public int getIncrement(){
        return (int)(getClicks() * SPEED_FACTOR);
    }
}
