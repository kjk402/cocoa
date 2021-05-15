package Week4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Mission7 extends JFrame {
    JButton bat;
    ImageIcon g = new ImageIcon("gotham.gif");
    Image go = g.getImage();
    public Mission7() {
        //setLayout(null);

        setSize(200, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        this.setSize(200, 200);

        bat = new JButton(new ImageIcon("src\\Week4\\batsym.gif"));


        //bat.setBounds(100,100,60,40);

        bat.setBorderPainted(false);
        bat.setFocusPainted(false);
        bat.setContentAreaFilled(false);
        //bat.setLocation(100,100);

        this.add(bat);

        bat.addKeyListener(new KeyHandler());

    }



    public static void main(String args[]) {
        Mission7 play = new Mission7();
        play.setVisible(true);

    }


    class KeyHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            String direction = e.getKeyText(e.getKeyCode());
            System.out.println(direction);
            int x=bat.getX();
            int y=bat.getY();

            if(direction.equals("Right")||direction.equals("D")) {
                if(x<550){
                    x+=10;
                }
            }
            else if(direction.equals("Left")||direction.equals("A")) {
                if(x>0) {
                    x-=10;
                }
            }
            else if(direction.equals("Down")||direction.equals("X")) {
                if (y<550) {
                    y+=10;
                }
            }
            else if(direction.equals("Up")||direction.equals("W")) {
                if (y>0) {
                    y-=10;
                }
            }
            else if(direction.equals("Q")) {
                if (x>0 && y>0) {
                    x -=10;
                    y-=10;
                }
            }
            else if(direction.equals("E")) {
                if (x<550 && y>0) {
                    x +=10;
                    y-=10;
                }
            }
            else if(direction.equals("Z")) {
                if (x>0 && y<550) {
                    x -=10;
                    y +=10;
                }
            }
            else if(direction.equals("C")) {
                if (x<550 && y<550) {
                    x +=10;
                    y +=10;
                }
            }
            bat.setLocation(x, y);
        }
    }
}
