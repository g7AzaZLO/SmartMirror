import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Fraze app = new Fraze(); //Создаем экземпляр нашего приложения
        app.setVisible(true); //Отображаем наше окно
        app.fraze(); //запуск виджета фраз
        app.clock(); //запуск виджета часов
    }
}
