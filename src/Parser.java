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
        String[] weatherArray = new String[10];
        int weatherCounter=0;
        for(Element unit : weatherUnit){
            String readyWeather = unit.toString(); //переводим в стринг наш блок с погодой
            String splitWeather = readyWeather.split("data-text=\"")[1]; //обрезаем лишнее перед погодой
            String dsplitWeather = splitWeather.split("\">")[0]; //обрезаем лишнее после погоды
            weatherArray[weatherCounter++] = dsplitWeather; //добавляем погоду в массив
        }
        String[] dayArray = new String[10];
        int dayCounter = 0;
        for(Element name : names){
            String day = name.text(); //выцепляем день, переводим в текст
            dayArray[dayCounter++] = day; // добавляем день в массив
        }
        dayArray[0] = "Сегодня";
        dayArray[1] = "Завтра";

        for(int i=0;i<10;i++){
            System.out.println(dayArray[i]+" -> "+ weatherArray[i]);
        }
    }


}
