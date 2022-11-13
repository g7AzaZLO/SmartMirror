import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class ParserNews {
    private static Document getPage() throws IOException {
        String url = "https://lenta.ru/rss/news";
        Document page = Jsoup.parse(new URL(url),10000);
        return page;
    }

    public static void main(String[] args) throws IOException{
        Document page = getPage(); //грузим страницу
        Elements news = page.select("item"); // цепляем новость
        Elements name = news.select("title"); // цепляем название
        Elements description = news.select("description"); // цепляем описание


        String[] titleArray = new String[9];
        int titleCounter = 0;
        try {
            for (Element unit : name) {
                String readyName = unit.toString();
                String rName = readyName.split(">")[1];
                String reName = rName.split("<")[0];
                titleArray[titleCounter] = reName;
                titleCounter++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        String[] descArray = new String[9];
        int descCounter = 0;
        try {
            for (Element unit : description) {
                String readyDesc = unit.toString();
                String rDesc = readyDesc.split("\\[")[2];
                String reDesc = rDesc.split("\\]")[0];
                descArray[descCounter] = reDesc;
                descCounter++;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        for(int i=0;i<9;i++){
            System.out.println(titleArray[i] + "\n" + descArray[i] + "\n");
        }
    }
}