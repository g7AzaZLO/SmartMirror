import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {
    private static Document getPage() throws IOException {
        String url = "https://www.gismeteo.ru/weather-moscow-4368/10-days/";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }

    public static void main(String[] args) throws IOException{
        Document page = getPage(); //грузим страницу
        Element tableWeather = page.select("div[class=widget-items]").first(); //выцепляем таблицу
        Elements names =  tableWeather.select("a"); //выцепляем дни с датой
        Element weather = tableWeather.select("div[class=widget-row widget-row-icon]").first(); //табличка с погодой
        Elements weatherUnit = weather.select("div[class=row-item]");//еще урезаем табл с погодой
        Element temperature = tableWeather.select("div[class=values]").first(); //выцепляем таблицу температуры
        Elements temperatureAll = temperature.select("div[class=value style_size_m]");


        String[] weatherArray = new String[10]; //массив погоды
        int weatherCounter=0;
        for(Element unit : weatherUnit){
            String readyWeather = unit.toString(); //переводим в стринг наш блок с погодой
            String splitWeather = readyWeather.split("data-text=\"")[1]; //обрезаем лишнее перед погодой
            String dsplitWeather = splitWeather.split("\">")[0]; //обрезаем лишнее после погоды
            weatherArray[weatherCounter++] = dsplitWeather; //добавляем погоду в массив
        }
        String[] dayArray = new String[10]; //массив дней
        int dayCounter = 0;
        for(Element name : names){
            String day = name.text(); //выцепляем день, переводим в текст
            dayArray[dayCounter++] = day; // добавляем день в массив
        }
        dayArray[0] = "Сегодня";
        dayArray[1] = "Завтра";

        String[] arrayTemperatureMax = new String[10]; //массив максимальной температуры
        int tempMaxCounter = 0;
        for(Element tempMax : temperatureAll){
            Element tempM = tempMax.select("div[class=maxt]").first();
            Element tempa = tempM.select("span[class=unit unit_temperature_c]").first(); //находим макс темп.
            String temper = tempa.text(); //извлекаем температуру из формы
            arrayTemperatureMax[tempMaxCounter++] = temper; //добавляем температуру в массив
        }

        String[] arrayTemperatureMin = new String[10]; //массив максимальной температуры
        int tempMinCounter = 0;
        for(Element tempMix : temperatureAll){
            Element tempM = tempMix.select("div[class=mint]").first();
            Element tempa = tempM.select("span[class=unit unit_temperature_c]").first(); //находим макс темп.
            String temper = tempa.text(); //извлекаем температуру из формы
            arrayTemperatureMin[tempMinCounter++] = temper; //добавляем в массив
        }

        for(int i=0;i<;i++){
            System.out.println(dayArray[i]+" -> "+ weatherArray[i]+" -> "+ arrayTemperatureMax[i]+" " + arrayTemperatureMin[i]);
        }
    }


}
