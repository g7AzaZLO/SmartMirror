import org.json.JSONObject;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Thread;

import static java.lang.String.format;

public class WindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна

    Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    JLabel weatherLabel;
    String time;


    public WindowApp(){
        super("SmartMirror"); //Заголовок окна
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
        this.setUndecorated(true); //безрамочный режим
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа
        this.getContentPane().setBackground(Color.BLACK); //задний фон окна черный
        this.setResizable(false); //на всякий случай убираем возможность изменения размера окна
        this.setLayout(null);

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int screensizex = ( int )size.getWidth();  // Записываем ширину экрана
        int screensizey = (int) size.getHeight();

        timeFormat = new SimpleDateFormat("hh:mm:ss"); //создаем формат времени
        timeLabel = new JLabel(); //создаем лейбл под время
        timeLabel.setForeground(Color.WHITE); //делаем текст белым
        timeLabel.setBounds(500,500,1000,400);
        this.add(timeLabel);


        String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=b74de8875b832c14c3e976231e043bd5&units=metric");
        JSONObject obj = new JSONObject(output);
        String[] qwe = {"Подробности на сегодня:",
                "Температура: " + (format("%.1f", obj.getJSONObject("main").getDouble("temp"))) + " ℃",
                "Ощущается: " + (format("%.1f", obj.getJSONObject("main").getDouble("feels_like"))) + " ℃" ,
                "Максимум: " + (format("%.1f", obj.getJSONObject("main").getDouble("temp_max"))) + " ℃",
                "Минимум: " + (format("%.1f", obj.getJSONObject("main").getDouble("temp_min"))) + " ℃",
                "Давление: " + (format("%.1f", obj.getJSONObject("main").getInt("pressure") / 1.333)) + " мм. рт."
        };

        int x = 1600;
        int y = -450;
        for(int i = 0; i < qwe.length; i++){
            weatherLabel = new JLabel(qwe[i]);
            weatherLabel.setBounds(x,y+i*20,1200,1000);
            weatherLabel.setForeground(Color.WHITE); //делаем текст белым
            this.add(weatherLabel);
        }
    }

    public void setTime(){ // функция обновления времени
        Thread timeThread = new Thread() {
            public void run() {
                for (; ; ) {
                    time = timeFormat.format(Calendar.getInstance().getTime()); //парсим время
                    timeLabel.setText(time); //устанавливаем в наш лейбл сам текст
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        timeThread.start();
    }

    //public void weather() {
    //    Thread weatherThread = new Thread() {
    //        public void run() {
    //            for(;;) {
    //                try{
    //                    String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=b74de8875b832c14c3e976231e043bd5&units=metric");
    //                    JSONObject obj = new JSONObject(output);
//
    //                    weatherLabel.setText("Подробности на сегодня:\n" +
    //                    "Температура: " + (format("%.1f", obj.getJSONObject("main").getDouble("temp"))) + " ℃" + "\n"+
    //                    "Ощущается: " + (format("%.1f", obj.getJSONObject("main").getDouble("feels_like"))) + " ℃\n" +
    //                    "Максимум: " + (format("%.1f", obj.getJSONObject("main").getDouble("temp_max"))) + " ℃\n" +
    //                    "Минимум: " + (format("%.1f", obj.getJSONObject("main").getDouble("temp_min"))) + " ℃\n" +
    //                    "Давление: " + (format("%.1f", obj.getJSONObject("main").getInt("pressure") / 1.333)) + " мм. рт.");
//
//
    //                    sleep(100000);
    //                }
    //                catch (Exception e){
    //                    e.printStackTrace();
    //            }
    //            }
    //        }
    //    };
    //    weatherThread.start();
    //}



    // Обработка URL адреса и получение данных с него
    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            System.out.println("Ошибка!");
        }
        return content.toString();
    }
}