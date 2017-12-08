import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener {


    public static class AtomBL implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            JButton button = (JButton)e.getSource();

            if("C".equals(e.getActionCommand()));
            System.out.println("In C!");
        }
    }



}
