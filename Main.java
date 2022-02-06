import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        System.out.println("Bitte Geben Sie ohne Dateiendung den Namen der Datei an für weitere Informationen.");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();

        if(fileName.equals("weather")){
            FileReaderWeather weather = new FileReaderWeather();
            try {
                weather.openFile("C:\\Users\\Danny\\Desktop\\" + fileName + ".csv");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (fileName.equals("football")){
            FileReaderFootball football = new FileReaderFootball();
            try {
                football.openFile("C:\\Users\\Danny\\Desktop\\" + fileName + ".csv");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Sie haben leider keinen Name einer Datei angegeben.");
        }
    }
}
