import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    String filepath;

    public Reader(String filepath) {
        this.filepath = filepath;
    }

    // a method to read a file line by line. It returns a string arraylist with the
    // lines of the file
    public ArrayList<String> readLines2() throws IOException, FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lines;
    }

}
