
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import static java.lang.String.format;

public class Controller {
    void initialize() {
        {
            // Получаем данные о погоде с сайта openweathermap(Конкретно о Москве)
            String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=b74de8875b832c14c3e976231e043bd5&units=metric");

            JSONObject obj = new JSONObject(output);
            // Обрабатываем JSON с выводом информации
            System.out.println("Погода сейчас:");
            System.out.println("Температура: " + (format("%.1f",obj.getJSONObject("main").getDouble("temp"))) + " ℃");
            System.out.println("Ощущается: " + (format("%.1f",obj.getJSONObject("main").getDouble("feels_like"))) + " ℃");
            System.out.println("Максимум: " + (format("%.1f",obj.getJSONObject("main").getDouble("temp_max"))) + " ℃");
            System.out.println("Минимум: " + (format("%.1f",obj.getJSONObject("main").getDouble("temp_min"))) + " ℃");
            System.out.print(("Давление: " + (format("%.1f",obj.getJSONObject("main").getInt("pressure")/1.333))) + " мм. рт.");
        }
    }


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
    public static void main(String[] args){
        Controller weather = new Controller();
        weather.initialize();
    }
}