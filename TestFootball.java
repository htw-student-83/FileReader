import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;

public class TestFootball {
    /**
     * Prüfung, ob die Datei überhaupt vorhanden ist
     */
    @Test
    public void foundFile(){
        File datei = new File("C:\\Users\\Danny\\Desktop\\football.csv");
        boolean foundFile = datei.exists();
        Assert.assertTrue(foundFile);
    }


    /**
     * Prüfung, ob man auf den Inhalt der Datei zugreifen kann
     */
    @Test
    public void toGetAccessToFile() {
        File datei = new File("C:\\Users\\Danny\\Desktop\\football.csv");
        boolean isAcess = datei.canRead();
        Assert.assertTrue(isAcess);
    }


    /**
     * Prüft, ob der Inhalte der Datei einelesen werden kann
     * @throws Exception
     */
    @Test
    public void isReadingFile() throws Exception {
        File datei = new File("C:\\Users\\Danny\\Desktop\\football.csv");
        java.io.FileReader getFile = new java.io.FileReader(datei);
        BufferedReader reader = new BufferedReader(getFile);
        String line =  reader.readLine();
        Assert.assertNotNull(line);
    }



    /**
     * Prüft, ob die Differenz zwischen den Spalten 5 und 6 berechnet werden kann
     * @throws Exception
     */
    @Test
    public void berechneDifferenz() throws Exception {
        File datei = new File("C:\\Users\\Danny\\Desktop\\football.csv");
        java.io.FileReader getFile = new java.io.FileReader(datei);
        BufferedReader reader = new BufferedReader(getFile);
        int torUnterschied = 0;
        String [] token;
        String line = ",";
        while((line = reader.readLine())!=null) {
            token = line.split(",");
            if(token[0].equals("Arsenal")){
                int tor_for_the_team = Integer.parseInt(token[5]);
                int tor_against_the_team = Integer.parseInt(token[6]);
                torUnterschied = tor_for_the_team - tor_against_the_team;
            }
        }
        Assert.assertTrue(torUnterschied>0);
    }
}
