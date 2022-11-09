import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock extends WindowApp {
    String time;
    SimpleDateFormat timeFormat = new SimpleDateFormat("EEEE, d LLLL, yyyy hh:mm:ss");
    public void clock(){

        Thread clockThread = new Thread(){ //запускаем новый поток
            public void run(){
                try {
                    for(;;){ //тупо бесконечный цикл
                        time = timeFormat.format(Calendar.getInstance().getTime()); //парсим время
                        timeLabel.setText(time); //устанавливаем в наш лейбл сам текст
                        sleep(1000); //время обновления виджета
                    }
                }
                catch (Exception e){ //обработка ошибки
                    e.printStackTrace();
                }
            }
        };
        clockThread.start();
    }
}
