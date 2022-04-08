import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Hello World!");

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the filepath: ");
        // String filepath = sc.nextLine();

        // Reader myReader = new Reader(filepath);
        Reader myReader = new Reader("diccionarioprueba.txt");
        String[] lines = myReader.readLines();

        String[] spanish_array = new String[lines.length];
        String[] english_array = new String[lines.length];
        String[] frech_array = new String[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] temp = lines[i].split(",");
            english_array[i] = temp[0];
            spanish_array[i] = temp[1];
            frech_array[i] = temp[2];
        }

        // print all the arrays. This is just to check that the file is read correctly
        for (int i = 0; i < lines.length; i++) {
            System.out.println(english_array[i] + " " + spanish_array[i] + " " + frech_array[i]);
        }

    }
}