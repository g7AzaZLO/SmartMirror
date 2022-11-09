import java.util.Random;

public class Fraze extends Clock {
    public void fraze(){
        Thread frazeThread = new Thread(){ //новый поток
            public void run(){
                try {
                    for(;;){ // бесконечный цикл
                        String[] frazeList = { //сюда добавлять фразы
                                "Прекрасно выглядишь",
                                "Как прошел твой день?",
                                "Хорошего дня!"
                        };
                        int rnd = new Random().nextInt(frazeList.length); //андомный выбор фразы
                        String fraze = frazeList[rnd]; //буферная переменная для фраз
                        frazeLabel.setText(fraze); //устанавливаем в наш лейбл сам текст
                        sleep(10000); //время обновления виджета
                    }
                }
                catch (Exception e){ //обработка ошибки
                    e.printStackTrace();
                }
            }
        };
        frazeThread.start();
    }
}
