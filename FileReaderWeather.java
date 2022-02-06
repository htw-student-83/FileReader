import java.io.*;

public class FileReaderWeather implements IFileReader {
    String line = "";
    final String delimiter = ",";
    private int smallestTemperatureDifferenz = 0;
    private int currentTemperatureDifferenz = 0;
    private int calcultedTemperatureDifferenz = 0;

    /**
     * Laden des Inhaltes der 1. - 3. Spalte der csv-Datei und Übergabe der einzelnen Werte
     * in den Spalten 2 und 3 an eine weitere Methode für die Bestimmung des Unterschiedes.
     * @param file
     * @throws IOException
     */
    @Override
    public void openFile(String file) throws IOException {
        FileReader getFile = new FileReader(file);
        BufferedReader reader = new BufferedReader(getFile);
        String[] token;
        String day = "";
        while ((line = reader.readLine()) != null) {
            token = line.split(delimiter);
            if(token[0].equals("1")){
                int temperaturMxt_Am_ersten_Tag = Integer.parseInt(token[1]);
                int temperaturMnt_Am_ersten_Tag = Integer.parseInt(token[2]);
                currentTemperatureDifferenz = temperaturMxt_Am_ersten_Tag - temperaturMnt_Am_ersten_Tag;
            }
            for(int i = 2; i<30; i++){
                int temperaturMxt = Integer.parseInt(token[1]);
                int temperaturMnt = Integer.parseInt(token[2]);
                calcultedTemperatureDifferenz = temperaturMxt - temperaturMnt;
            }
            smallestTemperatureDifferenz = toCalulateTheDifferenz(calcultedTemperatureDifferenz);

            if(calcultedTemperatureDifferenz == smallestTemperatureDifferenz){
                day = token[0];
            }
        }
        System.out.println();
        System.out.println("Am " + day + ". Tag eines monats ist der Temperaturenunterschied am kleinsten.");
        System.out.println("Die Differenz beträgt nämlich " + smallestTemperatureDifferenz + " Grad.");
        reader.close();
    }


    /**
     * Bestimmt den kleinsten Temperaturenunterschied
     * @param unterschiedNeu
     * @return kleinsterTemperaturenunterschied
     */
    @Override
    public int toCalulateTheDifferenz(int unterschiedNeu){
        if(currentTemperatureDifferenz>unterschiedNeu){
            this.currentTemperatureDifferenz = unterschiedNeu;
        }
        this.smallestTemperatureDifferenz = currentTemperatureDifferenz;
        return smallestTemperatureDifferenz;
    }
}