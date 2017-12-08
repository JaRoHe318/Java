import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import java.awt.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class MainClass extends JFrame {
    JPanel grid = new JPanel();
//    JLabel paHolder;

    public static void main(String[] args) {
        new MainClass();
    }

    public MainClass() {
        this.setTitle("Picture Application");
        this.setPreferredSize(new Dimension(600,600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        ImageIcon pic = new ImageIcon("c.png");



//        panel1.add(new JLabel(pic));
        createCells(pic);

//        panel1.add(grid,BorderLayout.CENTER);
        this.add(grid);
        this.setVisible(true);
        this.pack();
    }

    public void createCells(ImageIcon pic){
        grid.setLayout(new GridLayout(20,20));
        List<JLabel> holder = new ArrayList<>();
//        paHolder.setPreferredSize(new Dimension(10,10));
        for(int i=0;i<400;++i){
            holder.add(new JLabel(pic));
            holder.get(i).setPreferredSize(new Dimension(20,20));
            grid.add(holder.get(i));
        }
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}