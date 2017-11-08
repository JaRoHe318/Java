import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.util.Scanner;

public class Project3 extends JFrame {

    private int size=12;
    private int fontT=Font.PLAIN;
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
    private Font f = new Font("Times New Roman", fontT, size);



    JPanel bottom = new JPanel();

    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 500;


    public Project3() {
        createBottom();
        word.setFont(f);
        word.setLineWrap(true);
        add(wordScroll,BorderLayout.CENTER);

        openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser choosen = new JFileChooser();
                int isOpen = choosen.showOpenDialog(choosen);

                if(isOpen==JFileChooser.APPROVE_OPTION){
                    try {
                        FileReader read = null;
                        File newFile = choosen.getSelectedFile();
                        Scanner in = new Scanner(newFile);

                        while(in.hasNextLine()){
                            word.append(in.nextLine());
                            Process word;
                        }
                    }
                    catch(FileNotFoundException ex){

                    }

                }
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();

                if (chooser.showSaveDialog(chooser) == JFileChooser.APPROVE_OPTION) {
                    try {
                        FileWriter writeThis = new FileWriter(chooser.getSelectedFile());
                        writeThis.write(word.getText());
                        writeThis.close();

                    }
                    catch (IOException ex){

                    }
                }
            }

        });

        FontListener fl = new FontListener();

        fontSize.addActionListener(fl);

        fontType.addActionListener(fl);



        setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
    }

    class FontListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            size= (int)fontSize.getSelectedItem();

            if(fontType.getSelectedItem()=="Plain"){
                fontT=Font.PLAIN;
            }
            else if(fontType.getSelectedItem()=="Bold"){
                fontT=Font.BOLD;
            }
            else if(fontType.getSelectedItem()=="Italic"){
                fontT=Font.ITALIC;
            }

                f = new Font("Times New Roman", fontT, size);
                word.setFont(f);



        }


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
        frame.setName("Project 3");
        frame.setVisible(true);
        frame.pack();
    }
}
