

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint extends JPanel {

    public class Point {

        public int x;
        public int y;


        Point() {
            this.x = 0;
            this.y = 0;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }


    List<Point> myPoints ;


    Paint() {

        myPoints = new LinkedList<>();

        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        this.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                Point Point1 = new Point(x,y);
                myPoints.add(Point1);

                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void paintComponent(Graphics gr){
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        for (int i=0;i<myPoints.size();i++){
            g.fillOval(myPoints.get(i).x, myPoints.get(i).y, 20,20);
        }

        for (int i=1;i<myPoints.size();i++){
            //myPoints.get(i).x, myPoints.get(i).y, 20,20);
            g.drawLine(myPoints.get(i-1).x+10, myPoints.get(i-1).y+10, myPoints.get(i).x+10, myPoints.get(i).y+10);
        }


    }

    public static void main(String[] args){
        JFrame f = new JFrame("Paint");

        f.add(new Paint());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);

    }

}

