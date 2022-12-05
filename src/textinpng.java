public class textinpng {
    public static String png(String wet){
        String A="";
        if(wet.equals("Пасмурно")){
            return A+"pasmurno.png";
        }
        if(wet.equals("Пасмурно, мокрый снег")){
            return A+"snow.png";
        }
        if(wet.equals("Пасмурно, снег с дождем")){
            return A+"weathersnow.png";
        }
        if(wet.equals("Ясно")){
            return A+"sun.png";
        }
        if(wet.equals("Пасмурно, небольшой  снег")){
            return A+"littlesnow.png";
        }
        if(wet.equals("Облачно, небольшой  снег")){
            return A+"littlesnow.png";
        }
        if(wet.equals("Переменная облачность")){
            return A+"pasmurno.png";
        }
        if(wet.equals("Облачно")){
            return A+"pasmurno.png";
        }
        if(wet.equals("Переменная облачность, небольшой  снег")){
            return A+"littlesnow.png";
        }
        if(wet.equals("Переменная облачность,  снег")){
            return A+"littlesnow.png";
        }
        return "none";
    }
}