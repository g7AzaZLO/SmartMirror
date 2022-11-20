
public class textinpng {
    public static String png(String wet){
        if(wet.equals("Пасмурно")){
            return "pasmurno.png";
        }
        if(wet.equals("Пасмурно, мокрый снег")){
            return "snow.png";
        }
        if(wet.equals("Пасмурно, снег с дождем")){
            return "weathersnow.png";
        }
        if(wet.equals("Пасмурно, небольшой снег")){
            return "littlesnow.png";
        }
        if(wet.equals("Переменная облачность")){
            return "pasmurno.png";
        }
        if(wet.equals("Облачно")){
            return "pasmurno.png";
        }
        return "none";
    }
}
