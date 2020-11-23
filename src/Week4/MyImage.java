package Week4;
import java.awt.*;
import java.util.Random;

class MyImage extends Frame {

    static int xPixel = 300;
    static int yPixel = 300;

    Image myImage, offScreenImage;
    Graphics offScreenGraphics;

    public MyImage() {

        try {
            myImage = Toolkit.getDefaultToolkit().getImage("src\\Week4\\joker.gif");
        }
        catch(Exception e) {}
        setSize(800,600);
        setVisible(true);
        moveImage();

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {

        int width  = getWidth();
        int height = getHeight();

        if (offScreenImage == null) {
            offScreenImage    = createImage(width, height);
            offScreenGraphics = offScreenImage.getGraphics();
        }

        // clear the off screen image
        offScreenGraphics.clearRect(0, 0, width + 1, height + 1);

        // draw your image off screen
        offScreenGraphics.drawImage(myImage, xPixel, yPixel, this);

        // show the off screen image
        g.drawImage(offScreenImage, 0, 0, this);

    }

    void moveImage() {
        int k =1;
        for ( int i = 0 ; i < 50000 ; i++ ){

            System.out.println("next set of Pixels " + xPixel);
            Random rand = new Random();
            int r = rand.nextInt(20) ;
            int a = rand.nextInt(30) ;

            if (k>0 && k<2) {
                xPixel +=r;
                yPixel +=a;
                if (xPixel>=600 || yPixel>=600){
                    k +=1;
                }
            }
            if (k>1 && k<3) {
                xPixel -=a;
                yPixel +=r;
                if (xPixel<=30 || yPixel>=500) {
                    k +=1;
                }
            }
            if (k>2 && k<4) {
                xPixel -=r;
                yPixel -=a;
                if (xPixel<=30 || yPixel<=30) {
                    k +=1;
                }
            }
            if (k>3 && k<5) {
                xPixel +=a;
                yPixel -=r;
                if (xPixel>=600 || yPixel<=30) {
                    k -=3;
                }
            }




            repaint();

            // then sleep for a bit for your animation
            try { Thread.sleep(50); }   /* this will pause for 50 milliseconds */
            catch (InterruptedException e) { System.err.println("sleep exception"); }

        }
    }

    public static void main(String[] args){
        MyImage im = new MyImage();
        im.setVisible(true);

    }

}