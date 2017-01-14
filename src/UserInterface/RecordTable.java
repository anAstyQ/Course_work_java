package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;

public class RecordTable extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea textArea1;
    private String s ;

    public RecordTable() {
        setTitle("Records");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img=kit.getImage("nobad.jpg");
        setIconImage(img);
        try(FileReader reader = new FileReader("userlist.txt"))
        {
            // читаем посимвольно
            int k=0;
            int c;
            while((c=reader.read())!=-1){

                textArea1.insert(String.valueOf((char)c),k);
                k++;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }



        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(270,300);
        setResizable(false);
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
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
        Mainform a = new Mainform();
        a.setVisible(true);

    }
    public void setArea(String s){
        textArea1.append(s+"\n");
    }
}
