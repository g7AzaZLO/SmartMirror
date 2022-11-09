import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import java.lang.Thread;
import java.util.Random;

public class WindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна

    Calendar calendar;
    public JLabel timeLabel;
    JLabel frazeLabel;
    public WindowApp(){
        //----------------------Настройки окна---------------------------
        super("SmartMirror"); //Заголовок окна
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
        this.setUndecorated(true); //безрамочный режим
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа
        this.getContentPane().setBackground(Color.BLACK); //задний фон окна черный
        this.setResizable(false); //на всякий случай убираем возможность изменения размера окна
        this.setLayout(null);
        //-----------------------Виджет времени---------------------------
        timeLabel = new JLabel(); //создаем лейбл под время
        timeLabel.setForeground(Color.WHITE); //делаем текст белым
        this.add(timeLabel); //обавляем лэйб времени на экран
        timeLabel.setBounds(10,0,500,100); //ставим время ближе к центру в центр
        timeLabel.setFont(new Font("Calibri", Font.PLAIN,20));
        //-----------------------Виджет фраз-------------------------------
        frazeLabel = new JLabel("fraze",SwingConstants.CENTER); //создаем лейбл под время
        frazeLabel.setForeground(Color.WHITE); //делаем текст белым
        this.add(frazeLabel);//добавляем виджет на экран
        frazeLabel.setBounds(475,400,500,100);
        frazeLabel.setFont(new Font("Calibri", Font.PLAIN,50));
    }
}
