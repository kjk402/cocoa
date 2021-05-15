package Week4;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Vector;

public class LineDrawEx extends JFrame {

    JFrame frame = new JFrame("Swing Tester");
    public LineDrawEx(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new MyPanel());
        frame.setSize(800,600);
        frame.setVisible(true);

    }


    class MyPanel extends JPanel{

        Point startP=null;
        Point endP=null;

        Vector<Point> sv = new Vector<Point>(); // 시작
        Vector<Point> se = new Vector<Point>(); // 끝점

        public MyPanel(){
            //리스너를 공통으로해야  변수들이 공유된다.
            MyMouseListener ml = new MyMouseListener();

            this.addMouseListener(ml); // 리스너
            this.addMouseMotionListener(ml);
        }
        private BufferedImage bi = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
        private Graphics2D g2 = bi.createGraphics();
        public void paintComponent(Graphics g){
            super.paintComponent(g); // 부모 페인트호출

            if(sv.size() != 0){
                for(int i=0;i<se.size();i++){ //벡터크기만큼
                    Point sp = sv.get(i); // 벡터값을꺼내다
                    Point ep = se.get(i);
                    g.drawLine(sp.x, sp.y, ep.x, ep.y);//그리다
                }
            }
            if(startP != null)
                g.drawLine(startP.x, startP.y, endP.x, endP.y);
                g2.drawImage(bi, 0, 0, this);
        }

        class MyMouseListener extends MouseAdapter implements MouseMotionListener{
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
        JFrame frame = new JFrame("Swing Tester");
        frame.setSize(800,600);

        frame.setVisible(true);
        JMenuBar bar = new JMenuBar();
        frame.setJMenuBar(bar);
        JMenu fileMenu = new JMenu("File");
        //fileMenu.setMnemonic('F');
        bar.add(fileMenu);

        JMenu draw = new JMenu("Draw");
        bar.add(draw);

        JMenuItem line = new JMenuItem("Line");
        draw.add(line);
        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("line");
                new LineDrawEx();
            }
        });

        JMenuItem saveItem = new JMenuItem("Save");
        //saveItem.setMnemonic('S');
        fileMenu.add(saveItem);
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

                }
            }
        });

    }
}