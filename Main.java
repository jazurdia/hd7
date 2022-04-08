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
        // Reader myReader = new Reader("diccionarioprueba.txt"); // for testing
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
        BinaryTree<String, String> myBinaryTree = new BinaryTree<String, String>();
        for (int i = 0; i < english_array.length; i++) {
            myBinaryTree.insert(english_array[i], spanish_array[i]);
        }
        BinaryTree<String, String> myBinaryTree2 = new BinaryTree<String, String>();
        for (int i = 0; i < frech_array.length; i++) {
            myBinaryTree2.insert(frech_array[i], spanish_array[i]);
        }
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
            System.out.println("4. Modify the dictionary");
            System.out.println("5. Erase an entry from the dictionary");
            System.out.println("6. Exit");
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
                case 3: // translate a sentence from a txt file
                    System.out.println("Enter the filepath of the sentence you want to translate: ");
                    String filepath2 = sc.nextLine();
                    Reader myReader2 = new Reader(filepath2);
                    ArrayList<String> lines2 = myReader2.readLines2(); // each String is a line from the file.
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
                case 4: // erases and adds a new node. 
                    System.out.println("Select English or French: ");
                    String language = sc.next();                        
                    System.out.println("Enter the key of the word you want to modify: ");
                    String key = sc.next();
                    System.out.println("Enter the new translation: ");
                    String translation3 = sc.next();

                    if(language.equals("English")){
                        myBinaryTree.delete(key);
                        myBinaryTree.insert(key, translation3);
                    }
                    else if(language.equals("French")){
                        myBinaryTree2.delete(key);
                        myBinaryTree2.insert(key, translation3);
                    }
                    break;
                case 5: // erases a node
                    System.out.println("You have selected to erase an entry from the dictionary. ");
                    System.out.println("Select English or French: ");
                    String language2 = sc.next();
                    if (language2.equals("English")) {
                        System.out.println("Enter the word you want to erase: ");
                        String word4 = sc.next();
                        myBinaryTree.delete(word4);
                    } else if (language2.equals("French")) {
                        System.out.println("Enter the word you want to erase: ");
                        String word4 = sc.next();
                        myBinaryTree2.delete(word4);
                    } else {
                        System.out.println("Invalid option");
                    }
                    break;
                case 6:
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