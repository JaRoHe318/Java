import javax.swing.*;
import java.awt.*;

public class Project3 extends JFrame {

    private JTextArea word = new JTextArea();
    private JScrollPane wordScroll = new JScrollPane(word);
    private JComboBox fontType = new JComboBox();
    private JComboBox fontSize = new JComboBox();
    private JButton openBtn = new JButton("Open");
    private JButton saveBtn = new JButton("Save");
    private JButton findBtn = new JButton("Find");
    private JTextField findText = new JTextField(10);
    private JButton replaceBtn = new JButton("Replace All");
    private JTextField replaceText = new JTextField(10);

    JPanel bottom = new JPanel();

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 500;


    public Project3() {
        super("Project 3");
        word.setLineWrap(true);
        createBottom();
        add(wordScroll,BorderLayout.CENTER);

        setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
    }


    private void createBottom(){
        bottom.setLayout(new GridLayout(2, 4));
        bottom.add(openBtn);
        setComboBox();
        bottom.add(fontSize);
        bottom.add(findText);
        bottom.add(findBtn);
        bottom.add(saveBtn);
        bottom.add(fontType);
        bottom.add(replaceText);
        bottom.add(replaceBtn);

        add(bottom,BorderLayout.SOUTH);
    }

    private void setComboBox(){
        for(int i=8;i<=40;i+=2){
            fontSize.addItem(i);
        }
        fontType.addItem("Plain");
        fontType.addItem("Bold");
        fontType.addItem("Italic");
    }

    public static void main(String[] args)
    {
        JFrame frame = new Project3();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//for user

        frame.setVisible(true);
        frame.pack();
    }
}
