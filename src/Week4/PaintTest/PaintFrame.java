package Week4.PaintTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PaintFrame extends JFrame
{
    private PaintPanel paintPanel;
    private int shape = 0, thickness = 2;
    private Color color = Color.BLACK;
    private JButton ColorB, Undo, Redo, Eraser, Pen;
    public PaintFrame()
    {
        super("Painting");
        setLayout(new FlowLayout());
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        bar.add(fileMenu);

        Icon save = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\save.GIF");
        Icon open = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\open.GIF");

        JMenuItem saveItem = new JMenuItem("Save", save);
        saveItem.setMnemonic('S');
        fileMenu.add(saveItem);
        JMenuItem loadItem = new JMenuItem("Load", open);
        loadItem.setMnemonic('L');
        fileMenu.add(loadItem);

        JMenu Shape = new JMenu("Shape");
        Shape.setMnemonic('h');
        bar.add(Shape);

        Icon rect = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\rect.GIF");
        Icon oval = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\oval.GIF");
        Icon line = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\line.GIF");
        Icon fr = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\FR.GIF");
        Icon fo = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\FO.GIF");

        JMenuItem Rect = new JMenuItem("Rect", rect);
        Rect.setMnemonic('R');
        Shape.add(Rect);
        JMenuItem Oval = new JMenuItem("Oval", oval);
        Oval.setMnemonic('O');
        Shape.add(Oval);
        JMenuItem Line = new JMenuItem("Line", line);
        Line.setMnemonic('L');
        Shape.add(Line);
        JMenuItem FR = new JMenuItem("FR", fr);
        Shape.add(FR);
        JMenuItem FO = new JMenuItem("FO", fo);
        Shape.add(FO);

        Icon colors = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\colors.GIF");
        ColorB = new JButton(colors);
        ColorB.setToolTipText("Set Color");

        Icon move = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\move.GIF");
        Icon fill = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\fill.GIF");
        Icon border = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\border.GIF");
        Icon changesize = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\changesize.GIF");

        JMenu Functions = new JMenu("Functions");
        bar.add(Functions);

        JMenuItem filler = new JMenuItem("Fill", fill);
        Functions.add(filler);
        JMenuItem changeSize = new JMenuItem("Change Size", changesize);
        Functions.add(changeSize);
        JMenuItem changeLocation = new JMenuItem("Change Location", move);
        Functions.add(changeLocation);
        JMenuItem changeBorder = new JMenuItem("Change Border's Color", border);
        Functions.add(changeBorder);

        Icon back = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\undo.GIF");
        Icon forward = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\redo.GIF");
        Icon eraser = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\eraser.GIF");
        Icon pen = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\pen.png");

        Undo = new JButton(back);
        Undo.setToolTipText("Undo");
        Redo = new JButton(forward);
        Redo.setToolTipText("Redo");
        Eraser = new JButton(eraser);
        Eraser.setToolTipText("Erase");
        Pen = new JButton(pen);
        Pen.setToolTipText("Drawing Pen");

        JMenu Thickness = new JMenu("Thickness");
        bar.add(Thickness);

        Icon a = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\a.png");
        Icon b = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\b.png");
        Icon c = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\c.png");
        Icon d = new ImageIcon("C:\\Users\\jk2018\\Desktop\\cocoa\\paintboard\\자바 이미지\\d.png");

        JMenuItem thick1 = new JMenuItem("1", a);
        Thickness.add(thick1);
        JMenuItem thick2 = new JMenuItem("2", b);
        Thickness.add(thick2);
        JMenuItem thick3 = new JMenuItem("3", c);
        Thickness.add(thick3);
        JMenuItem thick4 = new JMenuItem("4", d);
        Thickness.add(thick4);

        paintPanel = new PaintPanel();
        add(ColorB);
        add(Undo);
        add(Redo);
        add(Eraser);
        add(Pen);
        add(paintPanel);
        ButtonHandler handler = new ButtonHandler();
        Undo.addActionListener(handler);
        Redo.addActionListener(handler);
        Eraser.addActionListener(handler);
        Pen.addActionListener(handler);
        saveItem.addActionListener(handler);
        loadItem.addActionListener(handler);
        thick1.addActionListener(handler);
        thick2.addActionListener(handler);
        thick3.addActionListener(handler);
        thick4.addActionListener(handler);
        Rect.addActionListener(handler);
        Oval.addActionListener(handler);
        Line.addActionListener(handler);
        FR.addActionListener(handler);
        FO.addActionListener(handler);
        ColorB.addActionListener(handler);
        filler.addActionListener(handler);
        changeSize.addActionListener(handler);
        changeLocation.addActionListener(handler);
        changeBorder.addActionListener(handler);
        paintPanel.setPreferredSize(new Dimension(1000, 700));
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == Undo)
            {
                paintPanel.undo();
            }
            else if(event.getSource() == Redo)
            {
                paintPanel.redo();
            }
            else if(event.getSource() == Eraser)
            {
                paintPanel.erase();
            }
            else if(event.getSource() == Pen)
            {
                paintPanel.pen();
            }
            else if(event.getActionCommand() == "1")
            {
                thickness = 2;
            }
            else if(event.getActionCommand() == "2")
            {
                thickness = 4;
            }
            else if(event.getActionCommand() == "3")
            {
                thickness = 8;
            }
            else if(event.getActionCommand() == "4")
            {
                thickness = 16;
            }
            else if(event.getActionCommand() == "Rect")
            {
                shape = 0;
                paintPanel.shape();
            }
            else if(event.getActionCommand() == "Oval")
            {
                shape = 1;
                paintPanel.shape();
            }
            else if(event.getActionCommand() == "Line")
            {
                shape = 2;
                paintPanel.shape();
            }
            else if(event.getActionCommand() == "FR")
            {
                shape = 3;
                paintPanel.shape();
            }
            else if(event.getActionCommand() == "FO")
            {
                shape = 4;
                paintPanel.shape();
            }
            else if(event.getSource() == ColorB)
            {
                color = JColorChooser.showDialog(null, "Choose a Color", color);
                if (color != null)
                    paintPanel.setColor(color);
            }
            else if(event.getActionCommand() == "Fill")
            {
                color = JColorChooser.showDialog(null, "Choose a Color", color);
                if (color != null)
                    paintPanel.ChangeFill(color);
            }
            else if(event.getActionCommand() == "Change Size")
            {
                paintPanel.ChangeSize();
            }
            else if(event.getActionCommand() == "Change Location")
            {
                paintPanel.ChangeLocation();
            }
            else if(event.getActionCommand() == "Change Border's Color")
            {
                color = JColorChooser.showDialog(null, "Choose a Color", color);
                if (color != null)
                    paintPanel.ChangeBorder(color);
            }
            else if(event.getActionCommand()=="Save")
            {
                try {
                    paintPanel.save();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else if(event.getActionCommand()=="Load")
            {
                try {
                    paintPanel.load();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            paintPanel.drawShape(shape, thickness);
        }
    }
}
