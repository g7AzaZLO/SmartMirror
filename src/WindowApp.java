import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.lang.reflect.GenericArrayType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Thread;
import java.util.GregorianCalendar;
import java.util.Random;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.concurrent.ExecutionException;

public class WindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна

    Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    String time;
    JLabel frazeLabel;

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
        this.add(timeLabel); //обавляем лэйб времени на экран
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); //для получения размера экрана
        int screensizex = ( int )size.getWidth();  // Записываем ширину экрана
        int screensizey = (int) size.getHeight(); // Записываем высоту экрана
        System.out.println(screensizex+" "+screensizey); // Выводим размер экрана()
        timeLabel.setBounds(screensizex/2,screensizey/2-100,100,40); //ставим время ближе к центру в центр

        frazeLabel = new JLabel(); //создаем лейбл под время
        frazeLabel.setForeground(Color.WHITE); //делаем текст белым
        this.add(frazeLabel);;
    }

    public void fraze(){
        Thread frazeThread = new Thread(){
            public void run(){
                try {
                    for(;;){
                        String[] frazeList = {
                                "Прекрасно выглядишь",
                                "Как прошел твой день?",
                                "Хорошего дня!"
                        };
                        int rnd = new Random().nextInt(frazeList.length);
                        String fraze = frazeList[rnd];
                        frazeLabel.setText(fraze); //устанавливаем в наш лейбл сам текст
                        sleep(10000);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        frazeThread.start();
    }

    public void clock(){
        Thread clockThread = new Thread(){
            public void run(){
                try {
                    for(;;){
                        time = timeFormat.format(Calendar.getInstance().getTime()); //парсим время
                        timeLabel.setText(time); //устанавливаем в наш лейбл сам текст
                        sleep(1000);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        clockThread.start();
    }
}
