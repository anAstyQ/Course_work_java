package Realization.Fifteens.Astar;

/**
 * Created by Anastasia on 22.12.2016.
 */

import Realization.Fifteens.Astar.Generating.GAndCheck;

import UserInterface.Myframes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Realize extends JFrame {
    private JPanel panel = new JPanel(new GridLayout(4, 4, 2, 2));
    private JPanel panel1 = new JPanel();
    public static int iterator = -1;
    private int[][] numbers = new int[4][4];
    private JLabel a3 = new JLabel();
    private int jk = 0;
    private int pause = 0;
    public Realize() {
        super("Пятнашки java 1.8 Безрукавая А.");
        setResizable(false);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img=kit.getImage("nobad.jpg");
        setIconImage(img);

        setBounds(200, 200, 300, 300);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        panel.setDoubleBuffered(true);

        panel.setBackground(Color.BLACK);

        panel1.setBounds(500,100,50,50);

        setSize(704,688);
        panel.setSize(704,688);


panel.setVisible(true);
        container.add(panel);
        GAndCheck a = new GAndCheck();
        a.generate(numbers);
        repaintField();
    }


    public void repaintField() {
        panel.removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton(Integer.toString(numbers[i][j]));

                Color c = new Color(26,75,75);
                button.setBackground(c);
                button.setBorderPainted(false);
                button.setFocusable(true);
                panel.add(button);
                if (numbers[i][j] == 0) {
                    button.setVisible(false);

                } else
                    button.addActionListener(new ClickListener());
                int k = Integer.parseInt(button.getText()) ;
System.out.println(k);
if(k!=0) {
    if (iterator == -1) {
    Font font = new Font("Rosewood STD Regular", Font.PLAIN, 72);
    button.setFont(font);
    button.setForeground(Color.white);}
    if (iterator == 1) {
        ImageIcon icon1 = createIcon("pictures/London bridge/" + k + ".jpg");
        button.setBackground(Color.BLACK);
        button.setIcon(icon1);
    }
    if (iterator == 2) {
        ImageIcon icon1 = createIcon("pictures/Night city/" + k + ".jpg");
        button.setBackground(Color.BLACK);
        button.setIcon(icon1);
    }
    if (iterator == 3) {
        ImageIcon icon1 = createIcon("pictures/Old city/" + k + ".jpg");
        button.setBackground(Color.BLACK);
        button.setIcon(icon1);
    }
    if (iterator == 4) {
        ImageIcon icon1 = createIcon("pictures/New city/" + k + ".jpg");
        button.setBackground(Color.BLACK);
        button.setIcon(icon1);
    }
    if (iterator == 5) {
        ImageIcon icon1 = createIcon("pictures/London bus/" + k + ".jpg");
        button.setBackground(Color.BLACK);
        button.setIcon(icon1);
    }
}

            }
        }

        panel.validate();
        panel.repaint();
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

    public boolean checkWin() {
        boolean status = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j > 2)
                    break;
                if (numbers[i][j] != i * 4 + j + 1) {
                    status = false;
                }
            }
        }
        return status;
    }




    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (pause==0) {
                JButton button = (JButton) e.getSource();
                button.setVisible(false);
                String name = button.getText();

                change(Integer.parseInt(name));
            }


        }


    }

    public void setPause(){
        pause=1;
    }

    public void setResume(){
        pause=0;
    }

    public void fastNew(){
        GAndCheck z = new GAndCheck();
        z.generate(numbers);
        repaintField();
    }

    public void change(int num) {
        int i = 0, j = 0;
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 4; l++) {
                if (numbers[k][l] == num) {
                    i = k;
                    j = l;
                }
            }
        }
        if (i > 0) {
            if (numbers[i - 1][j] == 0) {
                numbers[i - 1][j] = num;
                numbers[i][j] = 0;
            }
        }
        if (i < 3) {
            if (numbers[i + 1][j] == 0) {
                numbers[i + 1][j] = num;
                numbers[i][j] = 0;
            }
        }
        if (j > 0) {
            if (numbers[i][j - 1] == 0) {
                numbers[i][j - 1] = num;
                numbers[i][j] = 0;
            }
        }
        if (j < 3) {
            if (numbers[i][j + 1] == 0) {
                numbers[i][j + 1] = num;
                numbers[i][j] = 0;
            }
        }

        repaintField();
        jk++;

        if (checkWin()) {
            JOptionPane.showMessageDialog(null, "YOU WIN!", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            GAndCheck a = new GAndCheck();
            a.generate(numbers);
            repaintField();

       }
    }






}
