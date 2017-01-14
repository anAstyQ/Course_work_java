package UserInterface;

/**
 * Created by Anastasia on 26.12.2016.
 */
import Realization.Fifteens.Astar.Realize;
import Realization.Fifteens.Astar.TimerLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Myframes extends JFrame{
    public static int z=0;

    JButton button4 = new JButton("Exit");
    JButton button3 = new JButton("Generate New");
    TimerLabel a = new TimerLabel();
    JButton button1 = new JButton("Pause");
    JButton button2 = new JButton("Start");
    JButton button5 = new JButton("Save Result");
   public static JLabel lab1=new JLabel(" Current time: ");
    public Myframes(){


        Realize j = new Realize();
        j.setVisible(true);
        j.setLocation(313,27);
        JPanel panel1 = new JPanel();
setTitle("Instrumental panel");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img=kit.getImage("nobad.jpg");
        setIconImage(img);
       add(panel1);
        Color c = new Color(26,75,75);
        setBackground(c);
        panel1.setBackground(c);
        lab1.setForeground(Color.white);
        a.setForeground(Color.WHITE);
        Font font = new Font("Broadway", Font.ITALIC, 16);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setFont(font);

        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        button2.setFont(font);

        button3.setBackground(Color.BLACK);
        button3.setForeground(Color.WHITE);
        button3.setFont(font);

        button4.setBackground(Color.BLACK);
        button4.setForeground(Color.WHITE);
        button4.setFont(font);

        button5.setBackground(Color.BLACK);
        button5.setForeground(Color.WHITE);
        button5.setFont(font);

        lab1.setFont(font);
        a.setFont(font);

        panel1.add(lab1);
        panel1.add(a);
        panel1.add(button2);
        panel1.add(button1);
        panel1.add(button3);
        panel1.add(button5);
        panel1.add(button4);

        setSize(200,210);
        setResizable(false);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                j.setResume();
                a.resumeTimer();
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.setPause();
                a.pauseTimer();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.fastNew();
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                a.stopTimer();
                j.dispose();
                dispose();
                Mainform dialog = new Mainform();
                dialog.setVisible(true);

            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                a.stopTimer();
                j.dispose();
                dispose();
                Winner k = new Winner();
                k.setVisible(true);
                Mainform dialog = new Mainform();
                dialog.setVisible(true);
            }
        });
    }
}