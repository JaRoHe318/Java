import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoleculeGUI extends JFrame {

    private enum AtomType{
        HYDROGEN, CARBON, NITROGEN, OXYGEN, SULFER, CHLORINE,
        BROMINE, IODINE};

    List<Atom> atomHolder = new ArrayList<>();

    private AtomType makeAtom=AtomType.CARBON;

    private JPanel back = new JPanel();
    private JPanel left = new JPanel();
    private JPanel topLeft = new JPanel();
    private JPanel atomPanel = new JPanel();

    private JButton clear = new JButton("Clear");
    private JButton undo = new JButton("Undo");
    private JButton fix = new JButton("Fix");

    private JButton H = new JButton("H");
    private JButton C = new JButton("C");
    private JButton N = new JButton("N");
    private JButton O = new JButton("O");
    private JButton S = new JButton("S");
    private JButton Cl = new JButton("Cl");
    private JButton Br = new JButton("Br");
    private JButton I = new JButton("I");

    private Point mousePoint;

    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 600;

    public MoleculeGUI(){
        super("Molecule Maker");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/4-this.getSize().width/4,
                dim.height/6-this.getSize().height/4);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponents();
        this.pack();

    }

    private void addComponents(){
        back.setPreferredSize(new Dimension(700,500));
        back.setLayout(new BorderLayout());
        back.setBackground(Color.RED);
        createAtomPanel();
        createTopLeft();
        createLeft();
        back.add(new DrawingBoard());
        add(back);

    }

    private void createAtomPanel(){
        AtomBL listen = new AtomBL();

        atomPanel.setLayout(new GridLayout(4,2));
        H.setBackground(Color.lightGray);
        H.addActionListener(listen);
        atomPanel.add(H);

        C.setBackground(Color.gray);
        C.addActionListener(listen);
        atomPanel.add(C);

        N.setBackground(Color.blue);
        N.addActionListener(listen);
        atomPanel.add(N);

        O.setBackground(Color.RED);
        O.addActionListener(listen);
        atomPanel.add(O);

        S.setBackground(Color.PINK);
        S.addActionListener(listen);
        atomPanel.add(S);

        Cl.setBackground(Color.ORANGE);
        Cl.addActionListener(listen);
        atomPanel.add(Cl);

        Br.setBackground(Color.CYAN);
        Br.addActionListener(listen);
        atomPanel.add(Br);

        I.setBackground(Color.MAGENTA);
        I.addActionListener(listen);
        atomPanel.add(I);
    }

    private void createLeft(){
        left.setPreferredSize(new Dimension(100,500));
        left.setLayout(new BorderLayout());
        left.setBackground(Color.DARK_GRAY);
        left.add(topLeft,BorderLayout.NORTH);
        left.add(atomPanel,BorderLayout.SOUTH);
        back.add(left,BorderLayout.WEST);
    }

    private void createTopLeft(){
        topLeft.setLayout(new GridLayout(3,1));
        topLeft.add(clear);
        topLeft.add(undo);
        topLeft.add(fix);
    }


    public class AtomBL implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e){
                JButton button = (JButton)e.getSource();

                switch(e.getActionCommand()){
                    case "H":
                        makeAtom = AtomType.HYDROGEN;
                        System.out.println("In "+e.getActionCommand()+"!!!!");
                        break;
                    case "C":
                    makeAtom = AtomType.CARBON;
                        System.out.println("In "+e.getActionCommand()+"!!!!");

                        break;
                    case "N":
                        makeAtom = AtomType.NITROGEN;
                        System.out.println("In "+e.getActionCommand()+"!!!!");

                        break;
                    case "O":
                        makeAtom = AtomType.OXYGEN;
                        System.out.println("In "+e.getActionCommand()+"!!!!");
                        break;
                    case "S":
                        makeAtom = AtomType.SULFER;
                        System.out.println("In "+e.getActionCommand()+"!!!!");
                        break;
                    case "Cl":
                        makeAtom = AtomType.CHLORINE;
                        System.out.println("In "+e.getActionCommand()+"!!!!");
                        break;
                    case "Br":
                        makeAtom = AtomType.BROMINE;
                        System.out.println("In "+e.getActionCommand()+"!!!!");
                        break;
                    case "I":
                        makeAtom = AtomType.IODINE;
                        System.out.println("In "+e.getActionCommand()+"!!!!");
                        break;

                    default:
                        break;
                }


//                if("C".equals(e.getActionCommand()));
//                System.out.println("In C!");
            }
        }

    public Atom setAtoms(AtomType name){
        Atom newAtom = new Atom();
        BufferedImage atomImage;
        try {
            switch(name) {
                case CARBON:
                    System.out.println("In CarbonMaker!");
                    BufferedImage cImage =
                            ImageIO.read(getClass().getResource("AtomPics/c.png"));

                    newAtom = new Atom(4, "CARBON", cImage);
                    break;
                default:
                    break;
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return newAtom;
    }

    public class DrawingBoard extends JPanel{

        public DrawingBoard(){
            this.setBackground(Color.GREEN);
//            this.setPreferredSize(new Dimension(600,600));
            addMouseListener(new MouseInputAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    super.mouseClicked(e);
                    mousePoint = new Point(e.getPoint());
                    System.out.println("In ML\n( "+mousePoint.x+" , "+mousePoint.y+" )\n");
                    repaint();
                }
            });
        }
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            if(mousePoint != null){
                Atom newAtom = setAtoms(makeAtom);
                newAtom.setPoint(mousePoint);
                atomHolder.add(newAtom);
                for(Atom temp:atomHolder) {
                    temp.drawAtom(g);
                }

            }
        }
    }



}
