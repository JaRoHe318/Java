import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Final extends JFrame {

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new MoleculeGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
