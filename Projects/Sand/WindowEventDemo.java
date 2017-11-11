import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class WindowEventDemo extends JFrame implements WindowListener{


    WindowEventDemo(){
        addWindowListener(this);

        setSize(400,400);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new WindowEventDemo();
    }
    public void windowActivated(WindowEvent arg0) {
        System.out.println("activated");
    }
    public void windowClosed(WindowEvent arg0) {
        System.out.println("closed");
    }
    public void windowClosing(WindowEvent arg0) {

        int yesNo = JOptionPane.YES_NO_OPTION;
        int ans = JOptionPane.showConfirmDialog (this,
                "Would You Like to Close?",
                "Warning",yesNo);

        if(ans == JOptionPane.YES_OPTION){
            dispose();
        }else{

        }

    }
    public void windowDeactivated(WindowEvent arg0) {
        System.out.println("deactivated");
    }
    public void windowDeiconified(WindowEvent arg0) {
        System.out.println("deiconified");
    }
    public void windowIconified(WindowEvent arg0) {
        System.out.println("iconified");
    }
    public void windowOpened(WindowEvent arg0) {
        System.out.println("opened");
    }
}