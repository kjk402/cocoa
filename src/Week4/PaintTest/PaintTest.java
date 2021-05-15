package Week4.PaintTest;

import javax.swing.*;

public class PaintTest {
    public static void main( String[] args )
    {
        PaintFrame paintFrame = new PaintFrame();
        paintFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        paintFrame.setSize( 700, 600 );
        paintFrame.setVisible(true);
    }
}