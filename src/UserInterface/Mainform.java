package UserInterface;

import Realization.Fifteens.Astar.Realize;

import UserInterface.Settings.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class Mainform extends JDialog {
    private JPanel contentPane;
    private JButton play;
    private JButton records;
    private JButton settings;
    private JButton exit;
    private JButton INFOButton;


    public Mainform() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(play);
        setSize(300,250);
        setTitle("Пятнашки java 1.8 Безрукавая А.");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img=kit.getImage("nobad.jpg");
        setIconImage(img);



        Dimension screensize = kit.getScreenSize();
        setLocation(screensize.width/4+250,screensize.height/4+31);

        settings.setVisible(true);
        exit.setVisible(true);
        records.setVisible(true);
        play.setVisible(true);
        setResizable(false);
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                Myframes frame = new Myframes();
                frame.setVisible(true);
                frame.setLocation(1027,27);
            }
        });

        settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Settings a = new Settings();
                a.setVisible(true);

            }
        });

        records.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                onTable();
            }
        });

        INFOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String testFilePath = "info.txt";
                try {

                    Process process = Runtime.getRuntime().exec("notepad " + testFilePath);


                    process.waitFor();
                } catch ( Exception ex ) {
                    ex.printStackTrace();
                }

            }
        });

    }

    private void onTable(){
RecordTable a = new RecordTable();
a.setVisible(true);
    }




    private void onExit() {
        // add your code here
        dispose();
    }

}
