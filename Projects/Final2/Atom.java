
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Atom {

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
    public void setPoint(Point pos){
        this.pos = new Point(pos.x-atomX,pos.y-atomY);
//            this.pos.x=;
//            this.pos.y=;
//            this.pos=pos;
    }
    public Point getPoint(){
        return this.pos;
    }
}
