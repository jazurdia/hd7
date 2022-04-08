import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Hello World!");

        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the filepath: ");
        // String filepath = sc.nextLine();

        // Reader myReader = new Reader(filepath);
        Reader myReader = new Reader("diccionarioprueba.txt");
        ArrayList<String> lines = myReader.readLines2();

        String[] english_array = new String[lines.size()];
        String[] spanish_array = new String[lines.size()];
        String[] frech_array = new String[lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            String[] line = lines.get(i).split(",");
            english_array[i] = line[0];
            spanish_array[i] = line[1];
            frech_array[i] = line[2];
        }

        //Creating the binary trees. The first one is the english tree, the second one is the spanish tree and the third one is the french tree
        
        //create a binary search tree with the english words as keys and the spanish words as values using BinaryTree.java
        BinaryTree<String, String> myBinaryTree = new BinaryTree<String, String>();
        for (int i = 0; i < english_array.length; i++) {
            myBinaryTree.insert(english_array[i], spanish_array[i]);
        }

        //create a binary search tree with the french words as keys and the spanish words as values using BinaryTree.java
        BinaryTree<String, String> myBinaryTree2 = new BinaryTree<String, String>();
        for (int i = 0; i < frech_array.length; i++) {
            myBinaryTree2.insert(frech_array[i], spanish_array[i]);
        }

        boolean flag = false;
        while (!flag) {
            //menu
            System.out.println("Select the language you want to translate from: ");
            System.out.println("1. English");
            System.out.println("2. Spanish");
            System.out.println("3. French");
            System.out.println("4. Translate from a sentence");
            System.out.println("5. Exit");
            //scan the option
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            //switch the option
            switch (option) {
                case 1:
                    System.out.println("You selected English");
                    System.out.println("Enter the word you want to translate: ");
                    String word = sc.nextLine();
                    for (int i = 0; i < english_array.length; i++) {
                        if (word.equals(english_array[i])) {
                            System.out.println("The translation is: " + spanish_array[i]);
                        }
                    }
                    break;
                case 2:
                    System.out.println("You selected Spanish");
                    System.out.println("Enter the word you want to translate: ");
                    String word2 = sc.nextLine();
                    for (int i = 0; i < spanish_array.length; i++) {
                        if (word2.equals(spanish_array[i])) {
                            System.out.println("The translation is: " + english_array[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("You selected French");
                    System.out.println("Enter the word you want to translate: ");
                    String word3 = sc.nextLine();
                    for (int i = 0; i < frech_array.length; i++) {
                        if (word3.equals(frech_array[i])) {
                            System.out.println("The translation is: " + english_array[i]);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the filepath of the sentence you want to translate: ");
                    String filepath = sc.nextLine();
                    Reader myReader2 = new Reader(filepath);
                    ArrayList<String> lines2 = myReader2.readLines2(); //each String is a line from the file.

                    //search in lines2 for the words and print the translation using myBinaryTree and myBinaryTree2
                    for (int i = 0; i < lines2.size(); i++) {
                        String[] line = lines2.get(i).split(" "); //separate the words in the line
                        for (int j = 0; j < line.length; j++) { //search for the words in the line
                            if (myBinaryTree.search(line[j]) != null) { //if the word is in the english tree
                                System.out.print(myBinaryTree.search(line[j]) + " "); //print the translation
                            } else if (myBinaryTree2.search(line[j]) != null) { //if the word is in the french tree
                                System.out.print(myBinaryTree2.search(line[j]) + " "); //print the translation
                            } else {
                                System.out.print(line[j] + " "); //print the word
                            }
                        }
                    }
                    break;
                case 5:
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
                }
            }
        }
    }
}