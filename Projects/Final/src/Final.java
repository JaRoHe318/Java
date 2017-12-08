import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Final extends JFrame {

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

    private JPanel cells = new JPanel();

    private final int H1=1;
    private final int C12 = 12;
    private final int N10=10;
    private final int O16=16;
    private final int S32=18;
    private final int Cl36=20;
    private final int Br36=20;
    private final int I36=20;


    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 600;

    public class Atom{
        private int size;
        private Color color;
        private int bonds;

        Atom(){}
        Atom(int size,int bonds,Color color){
            this.size=size;
            this.bonds=bonds;
            this.color=color;
        }

    }

    public Final(){
        super("Final Project");

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/4-this.getSize().width/4,
                dim.height/6-this.getSize().height/4);

        back.setPreferredSize(new Dimension(700,500));
        back.setLayout(new BorderLayout());
        back.setBackground(Color.WHITE);
        add(back);
        createButtonMap();
        createAtomPanel();
        createTopLeft();
        createLeft();

//        setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
    }

    private void createAtoms(){
        Atom carbon = new Atom(C12,4,Color.blue);
        Atom nitrogen = new Atom(N10,3,Color.RED);
        Atom hydrogen = new Atom(H1,1,Color.gray);
//        Atom oxygen = new Atom(016,2,)
    }

    private void createAtomPanel(){
        atomPanel.setLayout(new GridLayout(4,2));
        H.setBackground(Color.lightGray);
        atomPanel.add(H);
        C.setBackground(Color.gray);
        atomPanel.add(C);
        N.setBackground(Color.blue);
        atomPanel.add(N);
        O.setBackground(Color.RED);
        atomPanel.add(O);
        S.setBackground(Color.PINK);
        atomPanel.add(S);
        Cl.setBackground(Color.ORANGE);
        atomPanel.add(Cl);
        Br.setBackground(Color.CYAN);
        atomPanel.add(Br);
        I.setBackground(Color.MAGENTA);
        atomPanel.add(I);

    }

    private void createButtonMap(){
        cells.setLayout(new GridLayout(25,25));
        for(int i=0;i<625;++i){
            cells.add(new JButton());
        }
    }
    class AtomListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    private void createLeft(){
        left.setPreferredSize(new Dimension(100,500));
        left.setLayout(new BorderLayout());
        left.setBackground(Color.DARK_GRAY);
        left.add(topLeft,BorderLayout.NORTH);
        left.add(atomPanel,BorderLayout.SOUTH);
        back.add(cells);
        back.add(left,BorderLayout.WEST);
    }

    private void createTopLeft(){
        topLeft.setLayout(new GridLayout(3,1));
        topLeft.add(clear);
        topLeft.add(undo);
        topLeft.add(fix);
    }


    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new MoleculeGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
