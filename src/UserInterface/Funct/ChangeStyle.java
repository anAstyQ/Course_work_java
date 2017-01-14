package UserInterface.Funct;

import Realization.Fifteens.Astar.Realize;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class ChangeStyle extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton pictureRadioButton;
    private int a = 0;
    private JComboBox comboBox1;
    private JLabel label1;


    public ChangeStyle() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img=kit.getImage("nobad.jpg");
        setIconImage(img);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Style settings");
        setResizable(false);
        a=Realize.iterator-1;
        System.out.println(a);
        if(a==-2){
    ImageIcon icon1 = createIcon("SettingsPictures/0.jpg");
    label1.setIcon(icon1);
    comboBox1.setSelectedIndex(0);
} else {ImageIcon icon1 = createIcon("SettingsPictures/"+a+".jpg");
            label1.setIcon(icon1);
            comboBox1.setSelectedIndex(a);
        pictureRadioButton.setSelected(true);}







        setSize(700,400);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
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

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ImageIcon icon1 = createIcon("SettingsPictures/"+comboBox1.getSelectedIndex()+".jpg");

                label1.setIcon(icon1);
            }
        });



pictureRadioButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {

    }
});


    }

    private void onOK() {
        // add your code here
        dispose();

        if(pictureRadioButton.isSelected()==true){Realize.iterator=comboBox1.getSelectedIndex()+1;}else{Realize.iterator=-1;}
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
    protected static ImageIcon createIcon(String path) {
        URL imgURL = Realize.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }
}
