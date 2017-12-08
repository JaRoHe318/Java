import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class createAtoms {
    enum AtomType{Hydrogen, Carbon, Oxygen, Nitrogen, Chlorine,
        Bromine };


    List<Atom> atomHolder = new ArrayList<>();

    public static void main(String[] args) {
        new createAtoms();
    }

    public createAtoms(){
        createFrame();
    }

    public void createFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawingBoard());
        frame.setVisible(true);
        frame.pack();
    }

    public Atom setAtoms(AtomType name){
        Atom newAtom = new Atom();
        BufferedImage atomImage;
        try {
            switch(name) {
                case Carbon:
                BufferedImage cImage =
                        ImageIO.read(getClass().getResource("AtomPics/c.png"));

                newAtom = new Atom(4, "Carbon", cImage);
                break;
                default:
                    break;
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    return newAtom;
    }
    public class Atom{
        //        Color color;
        private int bonds=0;
        private int atomX=0;
        private int atomY=0;
        private String name;
        private Point pos=null;
        private BufferedImage image=null;
        Atom(){
        }
        Atom(int bonds, String name, BufferedImage image){
            this.bonds=bonds;
            this.name = name;
            this.image=image;
            atomX=image.getWidth(null)/2;
            atomY=image.getHeight(null)/2;

//            ProcessAtom();
//            this.pos=pos;
//            this.color=color;
        }
        public void drawAtom(Graphics g){
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(this.image, pos.x,pos.y,null);
        }
        private void setPoint(Point pos){
            this.pos = new Point(pos.x-atomX,pos.y-atomY);
//            this.pos.x=;
//            this.pos.y=;
//            this.pos=pos;
        }
        public Point getPoint(){
            return this.pos;
        }
    }
    public class DrawingBoard extends JPanel{
        private Point mousePoint;
            public DrawingBoard(){
                this.setBackground(Color.WHITE);
                this.setPreferredSize(new Dimension(600,600));
                addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        mousePoint = new Point(e.getPoint());
                        System.out.println("( "+mousePoint.x+" , "+mousePoint.y+" )\n");
                        repaint();
                    }
                });
            }
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(mousePoint != null){
                    Atom newAtom = setAtoms(AtomType.Carbon);
                    newAtom.setPoint(mousePoint);
                    atomHolder.add(newAtom);
                    for(Atom temp:atomHolder) {
                        temp.drawAtom(g);
                    }

                }
            }
    }
}//===
