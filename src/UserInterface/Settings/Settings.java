package UserInterface.Settings;

import Realization.Fifteens.Astar.Realize;
import UserInterface.Funct.ChangeStyle;
import UserInterface.Mainform;
import UserInterface.Winner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Settings extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;

    private JButton DESTROYTABLEButton;
    private JButton interphaceButton;
    private int beg=0;
    public Settings() {
        setTitle("Settings");

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
setResizable(false);
        setSize(381,201);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screensize = kit.getScreenSize();
        setLocation(screensize.width/4+250,screensize.height/4+31);

        Image img=kit.getImage("nobad.jpg");
        setIconImage(img);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }

        });

        interphaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChangeStyle a = new ChangeStyle();
                a.setVisible(true);
            }
        });

DESTROYTABLEButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            FileWriter fstream1 = new FileWriter("Userlist.txt");// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception a)
        {System.err.println("Error in file cleaning: " + a.getMessage());}
    }
});



        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();

        Mainform dialog = new Mainform();
        dialog.setVisible(true);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
        Mainform dialog = new Mainform();
        dialog.setVisible(true);
    }

}
