package Week4.PaintTest;

import java.awt.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class PaintPanel extends JPanel
{
    private int pointCount = 0, howManyEraser = 0, howManyPen = 0;
    private int toDraw = 0, thickness = 2, mode = 0, stack = 0, maxstack = 0;
    private int borderstack = 0, fillstack = 0;
    private int[] whichOpLast = new int[10000], thicknesses = new int[10000];
    private int[] shape = new int[10000], fill = new int[10000], border = new int[10000];
    private Point[] startPt = new Point[10000], endPt = new Point[10000];
    private Point startChange, endChange;
    private int[][][] erasePt = new int[100][10000][2], penPt = new int[100][10000][2];
    private int[] eraseCount = new int[10000], penCount = new int[10000];
    private Color[] colors = new Color[10000];
    private Color color = Color.BLACK;
    private BufferedImage bi = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
    private Graphics2D g2d = bi.createGraphics();

    public PaintPanel()
    {
        setBackground(Color.WHITE);
        MouseHandler handler = new MouseHandler();
        super.addMouseListener(handler);
        super.addMouseMotionListener(handler);
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    public void drawShape(int shape, int thickness)
    {
        this.toDraw = shape;
        this.thickness = thickness;
    }
    public void undo()
    {
        if (stack == 0) {}
        else
        {
            stack--;
            if (whichOpLast[stack] == 0)
            {
                pointCount--;
            }
            else if (whichOpLast[stack] == 1)
            {
                howManyEraser--;
            }
            else if (whichOpLast[stack] == 2)
            {
                howManyPen--;
            }
            else if (whichOpLast[stack] == 3)
            {
                borderstack--;
            }
            else if (whichOpLast[stack] == 4)
            {
                fillstack--;
            }
        }
        repaint();
    }
    public void redo()
    {
        if (stack < maxstack)
        {
            if (whichOpLast[stack] == 0)
            {
                pointCount++;
            }
            else if (whichOpLast[stack] == 1)
            {
                howManyEraser++;
            }
            else if (whichOpLast[stack] == 2)
            {
                howManyPen++;
            }
            else if (whichOpLast[stack] == 3)
            {
                borderstack++;
            }
            else if (whichOpLast[stack] == 4)
            {
                fillstack++;
            }
            stack++;
        }
        repaint();
    }

    public void shape()
    {
        mode = 0;
    }
    public void erase()
    {
        mode = 1;
    }
    public void pen()
    {
        mode = 2;
    }
    public void ChangeSize()
    {
        mode = 3;
    }
    public void ChangeLocation()
    {
        mode = 4;
    }
    public void ChangeBorder(Color color)
    {
        mode = 5;
        this.color = color;
    }
    public void ChangeFill(Color color)
    {
        mode = 6;
        this.color = color;
    }
    private class MouseHandler implements MouseListener,
            MouseMotionListener
    {
        public void mouseClicked(MouseEvent event)
        {
            colors[stack] = color;
            if (maxstack == stack)
            {
                maxstack++;
            }
            if (mode == 5)
            {
                whichOpLast[stack++] = 3;
                for (int i = 0; i < pointCount; i++)
                {
                    if (((event.getPoint().getX() > startPt[i].getX() && event.getPoint().getX() < endPt[i].getX()) ||
                            (event.getPoint().getX() < startPt[i].getX() && event.getPoint().getX() > endPt[i].getX())) &&
                            ((event.getPoint().getY() > startPt[i].getY() && event.getPoint().getY() < endPt[i].getY()) ||
                                    (event.getPoint().getY() < startPt[i].getY() && event.getPoint().getY() > endPt[i].getY())))
                    {
                        border[borderstack++] = i;
                    }
                }
            }
            if (mode == 6)
            {
                whichOpLast[stack++] = 4;
                for (int i = 0; i < pointCount; i++)
                {
                    if (((event.getPoint().getX() > startPt[i].getX() && event.getPoint().getX() < endPt[i].getX()) ||
                            (event.getPoint().getX() < startPt[i].getX() && event.getPoint().getX() > endPt[i].getX())) &&
                            ((event.getPoint().getY() > startPt[i].getY() && event.getPoint().getY() < endPt[i].getY()) ||
                                    (event.getPoint().getY() < startPt[i].getY() && event.getPoint().getY() > endPt[i].getY())))
                    {
                        fill[fillstack++] = i;
                    }
                }
            }
        }
        public void mousePressed(MouseEvent event)
        {
            colors[stack] = color;
            thicknesses[stack] = thickness;
            if (maxstack == stack)
            {
                maxstack++;
            }
            if (mode == 0)
            {
                whichOpLast[stack++] = 0;
                startPt[pointCount] = event.getPoint();
                endPt[pointCount] = event.getPoint();
                shape[pointCount] = toDraw;
            }
            else if (mode == 1)
            {
                whichOpLast[stack++] = 1;
                eraseCount[howManyEraser] = 0;
                erasePt[howManyEraser][eraseCount[howManyEraser]][0] = event.getPoint().x;
                erasePt[howManyEraser][eraseCount[howManyEraser]++][1] = event.getPoint().y;
            }
            else if (mode == 2)
            {
                whichOpLast[stack++] = 2;
                penCount[howManyPen] = 0;
                penPt[howManyPen][penCount[howManyPen]][0] = event.getPoint().x;
                penPt[howManyPen][penCount[howManyPen]++][1] = event.getPoint().y;
            }
            else if ((mode == 3) && ((whichOpLast[stack - 1] == 0) || (whichOpLast[stack - 1] == 3) || (whichOpLast[stack - 1] == 4)))
            {
                endPt[pointCount] = event.getPoint();
            }
            else if ((mode == 4) && ((whichOpLast[stack - 1] == 0) || (whichOpLast[stack - 1] == 3) || (whichOpLast[stack - 1] == 4)))
            {
                startChange = event.getPoint();
                endChange = event.getPoint();
                startPt[pointCount - 1].setLocation(startPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
                        startPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
                endPt[pointCount - 1].setLocation(endPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
                        endPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
            }
        }
        public void mouseReleased(MouseEvent event)
        {
            if (mode == 0)
            {
                endPt[pointCount++] = event.getPoint();
            }
            else if (mode == 1)
            {
                erasePt[howManyEraser][eraseCount[howManyEraser]][0] = event.getPoint().x;
                erasePt[howManyEraser][eraseCount[howManyEraser]++][1] = event.getPoint().y;
                howManyEraser++;
            }
            else if (mode == 2)
            {
                penPt[howManyPen][penCount[howManyPen]][0] = event.getPoint().x;
                penPt[howManyPen][penCount[howManyPen]++][1] = event.getPoint().y;
                howManyPen++;

            }
            else if ((mode == 3) && ((whichOpLast[stack - 1] == 0) || (whichOpLast[stack - 1] == 3) || (whichOpLast[stack - 1] == 4)))
            {
                endPt[pointCount] = event.getPoint();
            }
            else if ((mode == 4) && ((whichOpLast[stack - 1] == 0) || (whichOpLast[stack - 1] == 3) || (whichOpLast[stack - 1] == 4)))
            {
                startChange = event.getPoint();
                endChange = event.getPoint();
                startPt[pointCount - 1].setLocation(startPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
                        startPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
                endPt[pointCount - 1].setLocation(endPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
                        endPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
            }
            repaint();
        }
        public void mouseEntered(MouseEvent event)
        {
        }
        public void mouseExited(MouseEvent event)
        {
        }
        public void mouseDragged(MouseEvent event)
        {
            if (mode == 0)
            {
                endPt[pointCount] = event.getPoint();
            }
            else if (mode == 1)
            {
                erasePt[howManyEraser][eraseCount[howManyEraser]][0] = event.getPoint().x;
                erasePt[howManyEraser][eraseCount[howManyEraser]++][1] = event.getPoint().y;
            }
            else if (mode == 2)
            {
                penPt[howManyPen][penCount[howManyPen]][0] = event.getPoint().x;
                penPt[howManyPen][penCount[howManyPen]++][1] = event.getPoint().y;
            }
            else if ((mode == 3) && ((whichOpLast[stack - 1] == 0) || (whichOpLast[stack - 1] == 3) || (whichOpLast[stack - 1] == 4)))
            {
                endPt[pointCount - 1] = event.getPoint();
            }
            else if ((mode == 4) && ((whichOpLast[stack - 1] == 0) || (whichOpLast[stack - 1] == 3) || (whichOpLast[stack - 1] == 4)))
            {
                endChange = event.getPoint();
                startPt[pointCount - 1].setLocation(startPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
                        startPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
                endPt[pointCount - 1].setLocation(endPt[pointCount - 1].getX() + endChange.getX() - startChange.getX(),
                        endPt[pointCount - 1].getY() + endChange.getY() - startChange.getY());
                startChange = event.getPoint();
            }
            repaint();
        }
        public void mouseMoved(MouseEvent event)
        {
        }
    }
    public void paintComponent(Graphics g)
    {
        int j = 0, k = 0, l = 0, m = 0, n = 0;
        super.paintComponent(g2d);
        g.drawImage(bi, 0, 0, this);

        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (int i = 0; i < stack; i++)
        {
            g.setColor(colors[i]);
            g2d.setColor(colors[i]);
            if (whichOpLast[i] == 0)
            {
                ((Graphics2D)g).setStroke(new BasicStroke(thicknesses[i]));
                g2d.setStroke(new BasicStroke(thicknesses[i]));
                if (shape[j] == 0)
                {
                    g.drawRect(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
                            endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
                    g2d.drawRect(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
                            endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
                }
                else if (shape[j] == 1)
                {
                    g.drawOval(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
                            endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
                    g2d.drawOval(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
                            endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
                }
                else if (shape[j] == 2)
                {
                    g.drawLine(endPt[j].x, endPt[j].y, startPt[j].x, startPt[j].y);
                    g2d.drawLine(endPt[j].x, endPt[j].y, startPt[j].x, startPt[j].y);
                }
                else if (shape[j] == 3)
                {
                    g.fillRect(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
                            endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
                    g2d.fillRect(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
                            endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
                }
                else if (shape[j] == 4)
                {
                    g.fillOval(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
                            endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
                    g2d.fillOval(endPt[j].x - startPt[j].x > 0 ? startPt[j].x : endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? startPt[j].y : endPt[j].y,
                            endPt[j].x - startPt[j].x > 0 ? endPt[j].x - startPt[j].x : startPt[j].x - endPt[j].x,
                            endPt[j].y - startPt[j].y > 0 ? endPt[j].y - startPt[j].y : startPt[j].y - endPt[j].y);
                }
                j++;
            }
            else if (whichOpLast[i] == 1)
            {
                g.setColor(Color.white);
                g2d.setColor(Color.white);
                for (int count = 0; count < eraseCount[k]; count++)
                {
                    g.fillOval(erasePt[k][count][0] - thicknesses[i], erasePt[k][count][1] - thicknesses[i], thicknesses[i] * 2, thicknesses[i] * 2);
                    g2d.fillOval(erasePt[k][count][0] - thicknesses[i], erasePt[k][count][1] - thicknesses[i], thicknesses[i] * 2, thicknesses[i] * 2);
                }
                k++;
            }
            else if (whichOpLast[i] == 2)
            {
                for (int count = 0; count < penCount[l]; count++)
                {
                    g.fillOval(penPt[l][count][0] - thicknesses[i], penPt[l][count][1] - thicknesses[i], thicknesses[i] * 2, thicknesses[i] * 2);
                    g2d.fillOval(penPt[l][count][0] - thicknesses[i], penPt[l][count][1] - thicknesses[i], thicknesses[i] * 2, thicknesses[i] * 2);
                }
                l++;
            }
            else if (whichOpLast[i] == 3)
            {
                if (shape[border[n]] == 0)
                {
                    g.drawRect(endPt[border[n]].x - startPt[border[n]].x > 0 ? startPt[border[n]].x : endPt[border[n]].x,
                            endPt[border[n]].y - startPt[border[n]].y > 0 ? startPt[border[n]].y : endPt[border[n]].y,
                            endPt[border[n]].x - startPt[border[n]].x > 0 ? endPt[border[n]].x - startPt[border[n]].x : startPt[border[n]].x - endPt[border[n]].x,
                            endPt[border[n]].y - startPt[border[n]].y > 0 ? endPt[border[n]].y - startPt[border[n]].y : startPt[border[n]].y - endPt[border[n]].y);
                    g2d.drawRect(endPt[border[n]].x - startPt[border[n]].x > 0 ? startPt[border[n]].x : endPt[border[n]].x,
                            endPt[border[n]].y - startPt[border[n]].y > 0 ? startPt[border[n]].y : endPt[border[n]].y,
                            endPt[border[n]].x - startPt[border[n]].x > 0 ? endPt[border[n]].x - startPt[border[n]].x : startPt[border[n]].x - endPt[border[n]].x,
                            endPt[border[n]].y - startPt[border[n]].y > 0 ? endPt[border[n]].y - startPt[border[n]].y : startPt[border[n]].y - endPt[border[n]].y);
                }
                else if (shape[border[n]] == 1)
                {
                    g.drawOval(endPt[border[n]].x - startPt[border[n]].x > 0 ? startPt[border[n]].x : endPt[border[n]].x,
                            endPt[border[n]].y - startPt[border[n]].y > 0 ? startPt[border[n]].y : endPt[border[n]].y,
                            endPt[border[n]].x - startPt[border[n]].x > 0 ? endPt[border[n]].x - startPt[border[n]].x : startPt[border[n]].x - endPt[border[n]].x,
                            endPt[border[n]].y - startPt[border[n]].y > 0 ? endPt[border[n]].y - startPt[border[n]].y : startPt[border[n]].y - endPt[border[n]].y);
                    g2d.drawOval(endPt[border[n]].x - startPt[border[n]].x > 0 ? startPt[border[n]].x : endPt[border[n]].x,
                            endPt[border[n]].y - startPt[border[n]].y > 0 ? startPt[border[n]].y : endPt[border[n]].y,
                            endPt[border[n]].x - startPt[border[n]].x > 0 ? endPt[border[n]].x - startPt[border[n]].x : startPt[border[n]].x - endPt[border[n]].x,
                            endPt[border[n]].y - startPt[border[n]].y > 0 ? endPt[border[n]].y - startPt[border[n]].y : startPt[border[n]].y - endPt[border[n]].y);
                }
                if (shape[border[n]] == 2)
                {
                    g.drawLine(endPt[border[n]].x, endPt[border[n]].y, startPt[border[n]].x, startPt[border[n]].y);
                    g2d.drawLine(endPt[border[n]].x, endPt[border[n]].y, startPt[border[n]].x, startPt[border[n]].y);
                }
                n++;
            }
            else if (whichOpLast[i] == 4)
            {
                if (shape[fill[m]] == 0)
                {
                    g.fillRect(endPt[fill[m]].x - startPt[fill[m]].x > 0 ? startPt[fill[m]].x + thicknesses[fill[m]] / 2 : endPt[fill[m]].x + thicknesses[fill[m]] / 2,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? startPt[fill[m]].y + thicknesses[fill[m]] / 2 : endPt[fill[m]].y + thicknesses[fill[m]] / 2,
                            endPt[fill[m]].x - startPt[fill[m]].x > 0 ? endPt[fill[m]].x - startPt[fill[m]].x - thicknesses[fill[m]] : startPt[fill[m]].x - endPt[fill[m]].x - thicknesses[fill[m]],
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? endPt[fill[m]].y - startPt[fill[m]].y - thicknesses[fill[m]] : startPt[fill[m]].y - endPt[fill[m]].y - thicknesses[fill[m]]);
                    g2d.fillRect(endPt[fill[m]].x - startPt[fill[m]].x > 0 ? startPt[fill[m]].x + thicknesses[fill[m]] / 2 : endPt[fill[m]].x + thicknesses[fill[m]] / 2,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? startPt[fill[m]].y + thicknesses[fill[m]] / 2 : endPt[fill[m]].y + thicknesses[fill[m]] / 2,
                            endPt[fill[m]].x - startPt[fill[m]].x > 0 ? endPt[fill[m]].x - startPt[fill[m]].x - thicknesses[fill[m]] : startPt[fill[m]].x - endPt[fill[m]].x - thicknesses[fill[m]],
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? endPt[fill[m]].y - startPt[fill[m]].y - thicknesses[fill[m]] : startPt[fill[m]].y - endPt[fill[m]].y - thicknesses[fill[m]]);
                }
                else if (shape[fill[m]] == 1)
                {
                    g.fillOval(endPt[fill[m]].x - startPt[fill[m]].x > 0 ? startPt[fill[m]].x + thicknesses[fill[m]] / 2 : endPt[fill[m]].x + thicknesses[fill[m]] / 2,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? startPt[fill[m]].y + thicknesses[fill[m]] / 2 : endPt[fill[m]].y + thicknesses[fill[m]] / 2,
                            endPt[fill[m]].x - startPt[fill[m]].x > 0 ? endPt[fill[m]].x - startPt[fill[m]].x - thicknesses[fill[m]] : startPt[fill[m]].x - endPt[fill[m]].x - thicknesses[fill[m]],
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? endPt[fill[m]].y - startPt[fill[m]].y - thicknesses[fill[m]] : startPt[fill[m]].y - endPt[fill[m]].y - thicknesses[fill[m]]);
                    g2d.fillOval(endPt[fill[m]].x - startPt[fill[m]].x > 0 ? startPt[fill[m]].x + thicknesses[fill[m]] / 2 : endPt[fill[m]].x + thicknesses[fill[m]] / 2,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? startPt[fill[m]].y + thicknesses[fill[m]] / 2 : endPt[fill[m]].y + thicknesses[fill[m]] / 2,
                            endPt[fill[m]].x - startPt[fill[m]].x > 0 ? endPt[fill[m]].x - startPt[fill[m]].x - thicknesses[fill[m]] : startPt[fill[m]].x - endPt[fill[m]].x - thicknesses[fill[m]],
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? endPt[fill[m]].y - startPt[fill[m]].y - thicknesses[fill[m]] : startPt[fill[m]].y - endPt[fill[m]].y - thicknesses[fill[m]]);
                }
                else if (shape[fill[m]] == 3)
                {
                    g.fillRect(endPt[fill[m]].x - startPt[fill[m]].x > 0 ? startPt[fill[m]].x : endPt[fill[m]].x,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? startPt[fill[m]].y : endPt[fill[m]].y,
                            endPt[fill[m]].x - startPt[fill[m]].x > 0 ? endPt[fill[m]].x - startPt[fill[m]].x : startPt[fill[m]].x - endPt[fill[m]].x,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? endPt[fill[m]].y - startPt[fill[m]].y : startPt[fill[m]].y - endPt[fill[m]].y);
                    g2d.fillRect(endPt[fill[m]].x - startPt[fill[m]].x > 0 ? startPt[fill[m]].x : endPt[fill[m]].x,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? startPt[fill[m]].y : endPt[fill[m]].y,
                            endPt[fill[m]].x - startPt[fill[m]].x > 0 ? endPt[fill[m]].x - startPt[fill[m]].x : startPt[fill[m]].x - endPt[fill[m]].x,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? endPt[fill[m]].y - startPt[fill[m]].y : startPt[fill[m]].y - endPt[fill[m]].y);
                }
                else if (shape[fill[m]] == 4)
                {
                    g.fillOval(endPt[fill[m]].x - startPt[fill[m]].x > 0 ? startPt[fill[m]].x : endPt[fill[m]].x,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? startPt[fill[m]].y : endPt[fill[m]].y,
                            endPt[fill[m]].x - startPt[fill[m]].x > 0 ? endPt[fill[m]].x - startPt[fill[m]].x : startPt[fill[m]].x - endPt[fill[m]].x,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? endPt[fill[m]].y - startPt[fill[m]].y : startPt[fill[m]].y - endPt[fill[m]].y);
                    g2d.fillOval(endPt[fill[m]].x - startPt[fill[m]].x > 0 ? startPt[fill[m]].x : endPt[fill[m]].x,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? startPt[fill[m]].y : endPt[fill[m]].y,
                            endPt[fill[m]].x - startPt[fill[m]].x > 0 ? endPt[fill[m]].x - startPt[fill[m]].x : startPt[fill[m]].x - endPt[fill[m]].x,
                            endPt[fill[m]].y - startPt[fill[m]].y > 0 ? endPt[fill[m]].y - startPt[fill[m]].y : startPt[fill[m]].y - endPt[fill[m]].y);
                }
                m++;
            }
        }

    }
    public void save() throws IOException
    {
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = filechooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File fileName = filechooser.getSelectedFile();
            ImageIO.write(bi, "PNG", fileName);
            System.out.println("Save Path: " + fileName.getPath());
        }
    }
    public void load() throws IOException
    {
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = filechooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File fileName = filechooser.getSelectedFile();
            bi = ImageIO.read(fileName);
            System.out.println("Load Path: " + fileName.getPath());
        }
    }
}
