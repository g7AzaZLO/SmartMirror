import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Thread;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
public class WindowApp extends JFrame { //Наследуя от JFrame мы получаем всю функциональность окна
    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    JLabel CalendarLabel;
    JLabel dataLabel;
    JLabel todayLabel;
    String time;
    JLabel frazeLabel;
    JLabel segodnyaLabel;
    JLabel tomorrowLabel;
    JLabel threedayLabel;
    JLabel fourLabel;
    JLabel fiveLabel;
    JLabel segodnyaLabeltext;
    JLabel tomorrowLabeltext;
    JLabel threedayLabeltext;
    JLabel fourLabeltext;
    JLabel fiveLabeltext;
    public WindowApp(){
        super("SmartMirror"); //Заголовок окна
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
        this.setUndecorated(true); //безрамочный режим
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //это нужно для того чтобы при закрытии окна закрывалась и программа
        this.getContentPane().setBackground(Color.BLACK); //задний фон окна черный
        this.setResizable(false); //на всякий случай убираем возможность изменения размера окна
        this.setLayout(null); //без этого иногда не работает setBounds
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); //для получения размера экрана
        int screensizex = ( int )size.getWidth();  // Записываем ширину экрана
        int screensizey = (int) size.getHeight(); // Записываем высоту экрана
        System.out.println(screensizex+" "+screensizey); // Выводим размер экрана()
        timeFormat = new SimpleDateFormat("HH:mm:ss"); //создаем формат времени
        timeLabel = new JLabel(); //создаем лейбл под время
        timeLabel.setForeground(Color.WHITE); //делаем текст белым
        this.add(timeLabel); //обавляем лэйб времени на экран
        timeLabel.setBounds(screensizex/2,screensizey/2-660,1000,400); //ставим время ближе к центру в центр
        frazeLabel = new JLabel(); //создаем лейбл под время
        frazeLabel.setHorizontalAlignment(JLabel.CENTER);
        CalendarLabel = new JLabel(); //создаем лейбл под дату
        this.getContentPane().setBackground(Color.BLACK); //задний фон окна черный
        frazeLabel.setBounds(screensizex/2-475,600,1000,400);
        frazeLabel.setForeground(Color.WHITE); //делаем текст белым
        this.add(frazeLabel);
        this.add(CalendarLabel);;//добавляем кнопку
        CalendarLabel.setBounds(JLabel.LEADING,JLabel.LEADING-130,1000,400); //ставим календарь ближе к центру в центр
        CalendarLabel.setForeground(Color.WHITE); //делаем текст белым
        dataLabel = new JLabel(); //создаем лейбл под время
        dataLabel.setForeground(Color.WHITE); //делаем текст белым
        this.add(dataLabel);
        dataLabel.setBounds(screensizex/2-710,screensizey/2-660,1000,400); //ставим время ближе к центру в центр
        /////////////////////////////////
        todayLabel = new JLabel(); //создаем лейбл под время
        this.add(todayLabel);
        todayLabel.setBounds(1450 ,JLabel.RIGHT-130 ,1000,400); //ставим время ближе к центру в центр
        //////////////////////////
        segodnyaLabel = new JLabel(); //создаем лейбл сегодня
        segodnyaLabeltext = new JLabel(); //создаем лейбл сегодня
        segodnyaLabeltext.setForeground(Color.WHITE); //делаем текст белым
        this.add(segodnyaLabel ); //обавляем лэйб времени на экран
        this.add(segodnyaLabeltext ); //обавляем лэйб времени на экран
        segodnyaLabel .setBounds(1390 ,JLabel.RIGHT-130 ,1000,400); ; //ставим время ближе к центру в центр
        segodnyaLabeltext .setBounds(1270 ,JLabel.RIGHT-130 ,1000,400); ; //ставим время ближе к центру в центр
        //////////////////////
        tomorrowLabel = new JLabel(); //создаем лейбл завтра
        this.add( tomorrowLabel); //обавляем лэйб времени на экран
        tomorrowLabel.setBounds(1390 ,JLabel.RIGHT-80 ,1000,400); //ставим время ближе к центру в центр
        tomorrowLabeltext = new JLabel(); //создаем лейбл завтра
        tomorrowLabeltext.setForeground(Color.WHITE); //делаем текст белым
        this.add( tomorrowLabeltext); //обавляем лэйб времени на экран
        tomorrowLabeltext.setBounds(1270 ,JLabel.RIGHT-80 ,1000,400); //ставим время ближе к центру в центр
        ///////////////////////
        threedayLabel = new JLabel(); //создаем лейбл послезавтра
        this.add(threedayLabel); //обавляем лэйб времени на экран
        threedayLabel.setBounds(1390 ,JLabel.RIGHT-30 ,1000,400); //ставим время ближе к центру в центр
        threedayLabeltext = new JLabel(); //создаем лейбл послезавтра
        threedayLabeltext.setForeground(Color.WHITE); //делаем текст белым
        this.add(threedayLabeltext); //обавляем лэйб времени на экран
        threedayLabeltext.setBounds(1270 ,JLabel.RIGHT-30 ,1000,400); //ставим время ближе к центру в центр
        ////////////////////////////
        fourLabel = new JLabel(); //создаем лейбл день 4
        this.add(fourLabel); //обавляем лэйб времени на экран
        fourLabel.setBounds(1390 ,JLabel.RIGHT+20 ,1000,400); //ставим время ближе к центру в центр
        fourLabeltext = new JLabel(); //создаем лейбл день 4
        fourLabeltext.setForeground(Color.WHITE); //делаем текст белым
        this.add(fourLabeltext); //обавляем лэйб времени на экран
        fourLabeltext.setBounds(1270 ,JLabel.RIGHT+20 ,1000,400); //ставим время ближе к центру в центр
        //////////////////
        fiveLabel = new JLabel(); //создаем лейбл день 5
        this.add(fiveLabel); //обавляем лэйб времени на экран
        fiveLabel.setBounds(1390 ,JLabel.RIGHT+70 ,1000,400); //ставим время ближе к центру в центр
        fiveLabeltext = new JLabel(); //создаем лейбл день 5
        fiveLabeltext.setForeground(Color.WHITE); //делаем текст белым
        this.add(fiveLabeltext); //обавляем лэйб времени на экран
        fiveLabeltext.setBounds(1270 ,JLabel.RIGHT+70 ,1000,400); //ставим время ближе к центру в центр
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
    public void data(){
        Thread dataThread = new Thread(){
            public void run(){
                try {
                    for(;;){
                        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
                        Date date = new Date();
                        dataLabel.setText("Текущая дата:  " + formatter.format(date)); //устанавливаем в наш лейбл сам текст
                        sleep(100000);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        dataThread.start();
    }
    public void Calendar(){
        Thread CalendarThread = new Thread(){
            public void run(){
                try {
                    for(;;){
                        String A="<html>";
                        String c="&nbsp ";
                        int schetchikprobelov=0;
                        int schetchiknovoystroki=0;
                        boolean fl=true;
                        // construct d as current date
                        GregorianCalendar d = new GregorianCalendar();

                        int today = d.get(Calendar.DAY_OF_MONTH);
                        int month = d.get(Calendar.MONTH);

                        // set d to start date of the month
                        d.set(Calendar.DAY_OF_MONTH, 1);

                        int weekday = d.get(Calendar.DAY_OF_WEEK);

                        // get first day of week (Sunday in the U.S.)
                        int firstDayOfWeek = d.getFirstDayOfWeek();

                        // determine the required indentation for the first line
                        int indent = 0;
                        while (weekday != firstDayOfWeek)
                        {
                            indent++;
                            d.add(Calendar.DAY_OF_MONTH, -1);
                            weekday = d.get(Calendar.DAY_OF_WEEK);
                        }

                        // print weekday names
                        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
                        do
                        {
                            A+=weekdayNames[weekday];A+=c;A+=c;
                            d.add(Calendar.DAY_OF_MONTH, 1);
                            weekday = d.get(Calendar.DAY_OF_WEEK);
                        }
                        while (weekday != firstDayOfWeek);
                        A+="<br>";

                        for (int i = 1; i <= indent; i++) {
                            A+=c;A+=c;A+=c;A+=c;
                        }

                        d.set(Calendar.DAY_OF_MONTH, 1);
                        do
                        {
                            // print day
                            int day = d.get(Calendar.DAY_OF_MONTH);
                            int day1=day;
                            if(day1/10==0){if (day == today){A+="<font bgcolor=red>";A+=today;A+="</font>";}else A+=day;A+=c;A+=c;if(fl==true)schetchikprobelov+=4;}
                            else
                            if(day1/100==0){if (day == today){A+="<font bgcolor=red>";A+=today;A+="</font>";}else A+=day;A+=c;if(fl==true)schetchikprobelov+=2;}
                            // mark current day with *
                            if (day == today){A+=c;}
                            else{A+=c;}

                            // advance d to the next day
                            d.add(Calendar.DAY_OF_MONTH, 1);
                            weekday = d.get(Calendar.DAY_OF_WEEK);

                            // start a new line at the start of the week
                            if (weekday == firstDayOfWeek){A+="<br>";if(fl==true)schetchiknovoystroki+=1;}
                        }
                        while (d.get(Calendar.MONTH) == month);
                        // the loop exits when d is day 1 of the next month

                        // print final end of line if necessary
                        if (weekday != firstDayOfWeek){A+="<br>";}
                        A+="<html>";
                        CalendarLabel.setText(A); //устанавливаем в наш лейбл сам текст
                        sleep(100000);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        CalendarThread.start();
    }

    public void Weather(){
        Thread WeatherThread = new Thread(){
            public void run(){
                try {
                    for(;;){
                        String pog,pogo;
                        Parser parsWeather = new Parser(); // объект класса парсера
                        textinpng tis = new textinpng();// объект класса перевода в пнг
                        for(int i=0;i<5;i++){ // проходимся 5 раз
                            String[] clearpog = parsWeather.weather(i); // забираем массив из парсера
                            if(i==0) {
                                pogo = clearpog[1]; //берем погоду из массива+
                                segodnyaLabeltext.setText(clearpog[0] +"   "+ clearpog[2]+ "   " + clearpog[3]); //устанавливаем в наш лейбл сам текст
                                pog = textinpng.png(pogo); // перегоняем его в название пнг файла
                                segodnyaLabel.setIcon(new ImageIcon(pog));
                            }
                            if(i==1) {
                                pogo = clearpog[1]; //берем погоду из массива
                                tomorrowLabeltext.setText(clearpog[0] +"   "+ clearpog[2]+ "   " + clearpog[3]); //устанавливаем в наш лейбл сам текст
                                pog = textinpng.png(pogo); // перегоняем его в название пнг файла
                                tomorrowLabel.setIcon(new ImageIcon(pog));
                            }
                            if(i==2) {
                                pogo = clearpog[1]; //берем погоду из массива
                                threedayLabeltext.setText(clearpog[0] +"   "+ clearpog[2]+ "   " + clearpog[3]); //устанавливаем в наш лейбл сам текст
                                pog = textinpng.png(pogo); // перегоняем его в название пнг файла
                                threedayLabel.setIcon(new ImageIcon(pog));
                            }
                            if(i==3) {
                                pogo = clearpog[1]; //берем погоду из массива
                                fourLabeltext.setText(clearpog[0] +"   "+ clearpog[2]+ "   " + clearpog[3]); //устанавливаем в наш лейбл сам текст
                                pog = textinpng.png(pogo); // перегоняем его в название пнг файла
                                fourLabel.setIcon(new ImageIcon(pog));
                            }
                            if(i==4) {
                                pogo = clearpog[1]; //берем погоду из массива
                                fiveLabeltext.setText(clearpog[0] +"   "+ clearpog[2]+ "   " + clearpog[3]); //устанавливаем в наш лейбл сам текст
                                pog = textinpng.png(pogo); // перегоняем его в название пнг файла
                                fiveLabel.setIcon(new ImageIcon(pog));
                            }
                        }
                        sleep(1000000);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        WeatherThread.start();
    }
}