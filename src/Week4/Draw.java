package Week4;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Draw {
    private BufferedImage bi = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
    private Graphics2D g2 = bi.createGraphics();
    JFrame frame = new JFrame("Drawing");
    public Draw() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Draw.MyPanel());
        frame.setSize(800,600);
        frame.setVisible(true);


        JMenuBar bar = new JMenuBar();
        frame.setJMenuBar(bar);
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        bar.add(fileMenu);
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.setMnemonic('S');
        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.setMnemonic('L');
        fileMenu.add(saveItem);
        fileMenu.add(loadItem);
        saveItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("push");
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG & GIF Images", "jpg", "gif");
                fileChooser.setFileFilter(filter);
                int userSelection = fileChooser.showSaveDialog(frame);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();
                    //ImageIO.write(bi, "PNG", fileName);
                    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                    try {
                        ImageIO.write(bi, "PNG", fileToSave);
                        System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                    } catch (NullPointerException ev) {
                        ev.printStackTrace();
                    } catch (IOException ev) {
                        ev.printStackTrace();
                    }
                }
            }
        });

        JMenu Shape = new JMenu("Shape");
        Shape.setMnemonic('S');
        bar.add(Shape);

        Icon square = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week4\\square.gif");
        Icon circle = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week4\\circle.gif");
        Icon line = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\src\\Week4\\line.gif");


        JMenuItem Rect = new JMenuItem("Square", square);
        Rect.setMnemonic('S');
        Shape.add(Rect);
        JMenuItem Oval = new JMenuItem("Circle", circle);
        Oval.setMnemonic('C');
        Shape.add(Oval);
        JMenuItem Line = new JMenuItem("Line", line);
        Line.setMnemonic('L');
        Shape.add(Line);


    }


    class MyPanel extends JPanel{

        Point startP=null;
        Point endP=null;

        Vector<Point> sv = new Vector<Point>(); // 시작
        Vector<Point> se = new Vector<Point>(); // 끝점

        public MyPanel(){
            //리스너를 공통으로해야  변수들이 공유된다.
            Draw.MyPanel.MyMouseListener ml = new Draw.MyPanel.MyMouseListener();

            this.addMouseListener(ml); // 리스너
            this.addMouseMotionListener(ml);
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g2); // 부모 페인트호출
            super.paintComponent(g);
            g2.setColor(Color.black);
            if(sv.size() != 0){
                for(int i=0;i<se.size();i++){ //벡터크기만큼
                    Point sp = sv.get(i); // 벡터값을꺼내다
                    Point ep = se.get(i);
                    g.drawLine(sp.x, sp.y, ep.x, ep.y);//그리다
                    g2.drawLine(sp.x, sp.y, ep.x, ep.y);
                    g2.drawImage(bi, 0, 0, this);
                }
            }
            if(startP != null)
                g.drawLine(startP.x, startP.y, endP.x, endP.y);
                g2.drawLine(startP.x, startP.y, endP.x, endP.y);
                g2.drawImage(bi, 0, 0, this);
        }

        class MyMouseListener extends MouseAdapter implements MouseMotionListener {
            public void mousePressed(MouseEvent e){
                startP = e.getPoint();
                sv.add(e.getPoint()); // 클릭한부분을 시작점으로
            }
            public void mouseReleased(MouseEvent e){
                se.add(e.getPoint()); // 드래그 한부분을 종료점으로
                endP = e.getPoint();
                repaint(); // 다시그려라
            }

            public void mouseDragged(MouseEvent e){
                endP = e.getPoint();
                repaint();
            }

            public void mouseMoved(MouseEvent e){

            }
        }
    }

    public static void main(String[] args) {
        new Draw();

    }
}
