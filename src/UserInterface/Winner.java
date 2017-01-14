package UserInterface;


import Realization.Fifteens.Astar.TimerLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Winner extends JDialog {
    String sq;
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textField1;
    private JLabel lab1;
public static String s="";

    public Winner() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img=kit.getImage("nobad.jpg");
        setIconImage(img);
        setTitle("Пятнашки java 1.8 Безрукавая А.");
        setContentPane(contentPane);
        setModal(true);
        setSize(350,250);
        getRootPane().setDefaultButton(buttonOK);
        lab1.setText(lab1.getText()+TimerLabel.get_Time());
        sq=TimerLabel.get_Time();
        setResizable(false);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        s=textField1.getText()+" "+sq;
        try(FileWriter writer = new FileWriter("userlist.txt", true))
        {
            // запись всей строки
            String text = s;
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }



        dispose();

    }
}
