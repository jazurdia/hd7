import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {

    String filepath;

    public Reader(String filepath) {
        this.filepath = filepath;
    }

    // a method to read a file line by line. It returns a string array with the
    // lines of the file
    public String[] readLines() {
        String[] lines = null;
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                lines[i] = line;
                i++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lines;


}
