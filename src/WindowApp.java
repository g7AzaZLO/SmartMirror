import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Thread;
public class WindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна

    Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    String time;

    public WindowApp(){
        super("SmartMirror"); //Заголовок окна
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
        this.setUndecorated(true); //безрамочный режим
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа
        this.getContentPane().setBackground(Color.BLACK); //задний фон окна черный
        this.setResizable(false); //на всякий случай убираем возможность изменения размера окна

        timeFormat = new SimpleDateFormat("hh:mm:ss"); //создаем формат времени
        timeLabel = new JLabel(); //создаем лейбл под время
        timeLabel.setForeground(Color.WHITE); //делаем текст белым
        this.add(timeLabel);

    }

    public void setTime(){
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime()); //парсим время
            timeLabel.setText(time); //устанавливаем в наш лейбл сам текст
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}