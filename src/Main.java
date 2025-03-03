
import ui.Stadium;


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Stadium stadium = new Stadium();
        frame.getContentPane().add(stadium);
        frame.setSize(640,480);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(
                dim.width / 2 - frame.getSize().width / 2,
                dim.height / 2 - frame.getSize().height / 2
        );
        frame.setVisible(true);
        stadium.setEventHandler(frame);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}