import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the filepath: ");
        String filepath = sc1.nextLine();

        Reader myReader = new Reader(filepath);
        // Reader myReader = new Reader("diccionarioprueba.txt");
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

        // Creating the binary trees. The first one is the english tree, the second one
        // is the spanish tree and the third one is the french tree

        // create a binary search tree with the english words as keys and the spanish
        // words as values using BinaryTree.java
        BinaryTree<String, String> myBinaryTree = new BinaryTree<String, String>();
        for (int i = 0; i < english_array.length; i++) {
            myBinaryTree.insert(english_array[i], spanish_array[i]);
        }

        // create a binary search tree with the french words as keys and the spanish
        // words as values using BinaryTree.java
        BinaryTree<String, String> myBinaryTree2 = new BinaryTree<String, String>();
        for (int i = 0; i < frech_array.length; i++) {
            myBinaryTree2.insert(frech_array[i], spanish_array[i]);
        }

        // print all the elements of both the english and french trees. Use the search
        // method from BinaryTree.java
        System.out.println("English tree: ");
        myBinaryTree.inOrder(myBinaryTree.root);
        System.out.println("French tree: ");
        myBinaryTree2.inOrder(myBinaryTree2.root);

        boolean flag = false;
        while (!flag) {
            // menu
            System.out.println("Select the language you want to translate from: ");
            System.out.println("1. English");
            System.out.println("2. French");
            System.out.println("3. Translate from a sentence");
            System.out.println("4. Exit");
            // scan the option
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            // switch the option
            switch (option) {
                case 1: // translate from english using the english tree
                    System.out.println("Enter the word you want to translate: ");
                    String word = sc.next();
                    String translation = myBinaryTree.search(word);
                    if (translation != null) {
                        System.out.println("The translation is: " + translation);
                    } else {
                        System.out.println("The word does not exist in the tree");
                        System.out.println("Do you want to insert it? (y/n)");
                        String answer = sc.next();
                        if (answer.equals("y")) {
                            System.out.println("Enter the translation: ");
                            String translation2 = sc.next();
                            myBinaryTree.insert(word, translation2);
                        }
                    }
                    break;
                case 2: // translate from French using the spanish tree
                    System.out.println("Enter the word you want to translate: ");
                    String word2 = sc.next();
                    String translation2 = myBinaryTree2.search(word2);
                    if (translation2 != null) {
                        System.out.println("The translation is: " + translation2);
                    } else {
                        System.out.println("The word does not exist in the tree");
                        System.out.println("Do you want to insert it? (y/n)");
                        String answer = sc.next();
                        if (answer.equals("y")) {
                            System.out.println("Enter the translation: ");
                            String translation3 = sc.next();
                            myBinaryTree2.insert(word2, translation3);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the filepath of the sentence you want to translate: ");
                    String filepath2 = sc.nextLine();
                    Reader myReader2 = new Reader(filepath2);
                    ArrayList<String> lines2 = myReader2.readLines2(); // each String is a line from the file.

                    // search in lines2 for the words and print the translation using myBinaryTree
                    // and myBinaryTree2
                    for (int i = 0; i < lines2.size(); i++) {
                        String[] line = lines2.get(i).split(" "); // separate the words in the line
                        for (int j = 0; j < line.length; j++) { // search for the words in the line
                            if (myBinaryTree.search(line[j]) != null) { // if the word is in the english tree
                                System.out.print(myBinaryTree.search(line[j]) + " "); // print the translation
                            } else if (myBinaryTree2.search(line[j]) != null) { // if the word is in the french tree
                                System.out.print(myBinaryTree2.search(line[j]) + " "); // print the translation
                            } else {
                                System.out.print(line[j] + " "); // print the word
                            }
                        }
                    }
                    break;
                case 4:
                    flag = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}