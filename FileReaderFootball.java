import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderFootball implements IFileReader {
    String line = "";
    final String delimiter = ",";
    private int smallestGoalDifferenz = 0;
    private int firstGoalDifferenz = 0;
    private int goalDifferenz = 0;

    /**
     * Laden des Inhaltes der 1. und 5. und 6. Spalte der csv-Datei und Übergabe der einzelnen Werte
     * in den Spalten 5 und 6 an eine weitere Methode für die Bestimmung des Unterschiedes.
     * @param file
     * @throws IOException
     */
    @Override
    public void openFile(String file) throws IOException {
        java.io.FileReader getFile = new java.io.FileReader(file);
        BufferedReader reader = new BufferedReader(getFile);
        String[] token;
        String team = "";
        while ((line = reader.readLine()) != null) {
            token = line.split(delimiter);
            if(token[0].equals("Arsenal")){
                int goals_for_the_team_row_one = Integer.parseInt(token[5]);
                int goals_against_the_team_row_one = Integer.parseInt(token[6]);
                this.firstGoalDifferenz = goals_for_the_team_row_one - goals_against_the_team_row_one;
            }
            for(int i = 2; i<=21; i++){
                int goals_for_the_team = Integer.parseInt(token[5]);
                int goals_against_the_team = Integer.parseInt(token[6]);
                goalDifferenz = (int)Math.sqrt(Math.pow((goals_for_the_team-goals_against_the_team),2));
            }
            smallestGoalDifferenz = toCalulateTheDifferenz(goalDifferenz);

            if(goalDifferenz == smallestGoalDifferenz){
                team = token[0];
            }
        }
        System.out.print("Das Team " + team + " weist mit einer Differenz von " + smallestGoalDifferenz);
        System.out.print(" den kleinsten Torunterschied auf.");
        reader.close();
    }


    /**
     * Bestimmt den kleinsten Torunterschied
     * @param unterschiedNeu
     * @return kleinsterTorunterschied
     */
    @Override
    public int toCalulateTheDifferenz(int unterschiedNeu){
        if(firstGoalDifferenz>unterschiedNeu){
            this.firstGoalDifferenz = unterschiedNeu;
        }
        this.smallestGoalDifferenz = firstGoalDifferenz;
        return smallestGoalDifferenz;
    }
}
