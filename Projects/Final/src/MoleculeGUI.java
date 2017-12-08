import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MoleculeGUI extends JFrame{
    private JPanel back = new JPanel();
    private JPanel left = new JPanel();
    private JPanel topLeft = new JPanel();
    private JPanel atomPanel = new JPanel();
    private JPanel cells = new JPanel();

    private JButton clear = new JButton("Clear");
    private JButton undo = new JButton("Undo");
    private JButton fix = new JButton("Fix");

    private JButton H = new JButton("H");
    private final int H1=1;
    private JButton C = new JButton("C");
    private final int C12 = 12;
    private JButton N = new JButton("N");
    private final int N10=10;
    private JButton O = new JButton("O");
    private final int O16=16;
    private JButton S = new JButton("S");
    private final int S32=18;
    private JButton Cl = new JButton("Cl");
    private final int Cl36=20;
    private JButton Br = new JButton("Br");
    private final int Br36=20;
    private JButton I = new JButton("I");
    private final int I36=20;

    private static final int FRAME_WIDTH = 700;
    private static final int FRAME_HEIGHT = 600;

    public MoleculeGUI(){
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

    private void createAtomPanel(){
        ActionListener listen = new Listener.AtomBL();

        atomPanel.setLayout(new GridLayout(4,2));
        H.setBackground(Color.lightGray);
        atomPanel.add(H);

        C.setBackground(Color.gray);
        C.addActionListener(listen);
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
        cells.setLayout(new GridLayout(20,20));

        for(int i=0;i<400;++i){
            cells.add(new JButton());
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
}
