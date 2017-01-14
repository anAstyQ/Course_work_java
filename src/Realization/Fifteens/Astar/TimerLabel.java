package Realization.Fifteens.Astar;

import UserInterface.Myframes;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by Anastasia on 23.12.2016.
 */@SuppressWarnings ("serial")
public class TimerLabel extends JLabel
{
    private DecimalFormat decimalFormat = new DecimalFormat("00");
    private Timer timer = new Timer();
    private TimerTask timerTask;
    private static int a=1;

    private static String s ="";
    public TimerLabel ()
    {

        Color c = new Color(26,75,75);
        setBackground(c);
        restartTimer();
    }
public void pauseTimer(){
    a=0;

}



public static String get_Time(){
    return s;
}
    public void resumeTimer(){

       a=1;

    }



    public void restartTimer()
    {
        stopTimer();

        timerTask = new TimerTask() {
            private volatile int time = -1;
            @Override
            public void run() {
                if (a==1){  time++;}
                SwingUtilities.invokeLater(new Runnable()
                {
                    @Override
                    public void run(){

                        int t = time;
                        TimerLabel.this.setText(decimalFormat.format(t / 60) + ":" + decimalFormat.format(t % 60));
                        s=decimalFormat.format(t / 60) + ":" + decimalFormat.format(t % 60);
                    System.out.println(s);

                    }
                });
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    public void stopTimer()
    {
        if (timerTask != null) {
            timerTask.cancel();
        }}
}
