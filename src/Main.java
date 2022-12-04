public class Main {
    public static void main(String[] args) {
        WindowApp app = new WindowApp(); //Создаем экземпляр нашего приложения
        app.fraze();
        app.clock();
        app.Calendar();
        app.data();
        app.Weather();
        app.setVisible(true); //Отображаем наше окно
    }
}