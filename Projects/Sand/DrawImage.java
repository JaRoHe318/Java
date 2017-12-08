import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class DrawImage {

    public static void main(String[] args) {
        new DrawImage();
    }

    public DrawImage() {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TestPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }









    public class TestPane extends JPanel {
        private BufferedImage image;
        private Point drawPoint;

        public TestPane() {
            try {
                image = ImageIO.read(getClass().getResource("c.png"));

//                addMouseListener(new MouseAdapter() {
//
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        drawPoint = new Point(e.getX(), e.getY());
//                        repaint();
//                    }
//
//                });


                addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        drawPoint = new Point(e.getPoint());
                        repaint();
                    }
                });
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 600);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int imageW = image.getWidth(null) / 2;
            int imageH = image.getHeight(null) / 2;
            List<Graphics2D> jar = new ArrayList<>();
            if (drawPoint != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(image, drawPoint.x-imageW, drawPoint.y-imageH, this);
                jar.add(g2d);
                g2d.dispose();
            }

        }

    }
}