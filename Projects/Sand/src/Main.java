import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Main {


    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setTitle("Basic AF");

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(200,100));
        panel1.setBackground(Color.darkGray);

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(200,200));
        panel2.setBackground(Color.LIGHT_GRAY);

        JButton button = new JButton("Click Me!");

        ButtonListener btnLis = new ButtonListener();

        button.addActionListener(btnLis);
        panel2.add(button);

        panel1.add(panel2);

        JLabel first = new JLabel("Enter: ");
        first.setPreferredSize(new Dimension(100,100));
        first.setBackground(Color.green);
        panel1.setPreferredSize(new Dimension(100,100));

        panel1.add(first);

        JTextField firstField = new JTextField(10);
        panel1.add(firstField);

        JLabel second =  new JLabel("Second: ");
        panel1.add(second);
        JTextField secondField = new JTextField(10);
        panel1.add(secondField);


        f.add(panel1);

        f.setPreferredSize(new Dimension(600,500));

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.pack();

        f.setVisible(true);
    }//void main


    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("I got called");
            if(panel2.getBackground().equals(Color.darkGray)){
                panel2.setBackground(Color.black);
            }if(panel2.getBackground().equals(Color.black)){
                panel2.setBackground(Color.darkGray);
            }else{
                panel2.setBackground(Color.blue);
            }
        }

    }

}//class Main
