import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;


public class TestWeater {

    /**
     * Prüfung, ob die Datei überhaupt vorhanden ist
     */
    @Test
    public void foundFile(){
        File datei = new File("C:\\Users\\Danny\\Desktop\\weather.csv");
        boolean foundFile = datei.exists();
        Assert.assertTrue(foundFile);
    }


    /**
     * Prüfung, ob man auf den Inhalt der Datei zugreifen kann
     */
    @Test
    public void toGetAccessToFile() {
        File datei = new File("C:\\Users\\Danny\\Desktop\\weather.csv");
        boolean isAcess = datei.canRead();
        Assert.assertTrue(isAcess);
    }


    /**
     * Prüft, ob der Inhalte der Datei eingelesen werden kann
     * @throws Exception
     */
    @Test
    public void isReadingFile() throws Exception {
        File datei = new File("C:\\Users\\Danny\\Desktop\\weather.csv");
        java.io.FileReader getFile = new java.io.FileReader(datei);
        BufferedReader reader = new BufferedReader(getFile);
        String line =  reader.readLine();
        Assert.assertNotNull(line);
    }


    /**
     * Prüft, ob die Differenz zwischen den Spalten 2 und 3 berechnet werden kann
     * @throws Exception
     */
    @Test
    public void berechneDifferenz() throws Exception {
        File datei = new File("C:\\Users\\Danny\\Desktop\\weather.csv");
        java.io.FileReader getFile = new java.io.FileReader(datei);
        BufferedReader reader = new BufferedReader(getFile);
        int temperaturenunterschied = 0;
        String [] token;
        String line = ",";
        while((line = reader.readLine())!=null) {
            token = line.split(",");
            if(token[0].equals("1")){
                int temperaturMxt = Integer.parseInt(token[1]);
                int temperaturMnt = Integer.parseInt(token[2]);
                temperaturenunterschied = temperaturMxt - temperaturMnt;
            }
        }
        Assert.assertTrue(temperaturenunterschied>0);
    }
}
