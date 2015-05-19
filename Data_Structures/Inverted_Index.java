package Data_Structures;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program: Inverted Index Data Structure
 * Programmer: Harsha Kuchampudi
 * Date: May 18, 2015
 *
 * Description: Inverted index example program, the user
 * enters a word and the program walks through each character
 * and shows the search process
 */

public class Inverted_Index {

    public static void main(String []args) throws IOException {

        // Scanner Creation
        Scanner input = new Scanner(System.in);

        // Get Word List
        System.out.print("Please Enter the Path to Your Word List: ");
        String workingDir = input.next();
        File wordList = new File(workingDir);

        // User Interaction Dialogue
        System.out.print("Please Enter the Word You Want to Search: ");
        String userSearch = input.next();

        // Read the Word List and Return an Array Containing all the Words
        ArrayList<String> wordsinList = readFile(wordList);

        // Inverted Index Search
        ArrayList<String> results = invertedIndexSearch(userSearch, wordsinList);

        // Output
        System.out.println("Your Search Results: " + results);

    }

    public static ArrayList<String> readFile(File inputFile) throws IOException {

        // List that Stores All Words in the List
        ArrayList<String> wordList = new ArrayList<>();

        // File Reading Initialization
        FileInputStream inputStream = new FileInputStream(inputFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // Stores Each Line
        String line = null;

        // While There is Another Line, Add the Word to the Word List
        while((line = bufferedReader.readLine()) != null){
            wordList.add(line);

        }

        // Close the Buffered Reader
        bufferedReader.close();

        // Return the Word List
        return wordList;

    }

    public static ArrayList<String> invertedIndexSearch(String searchTerm, ArrayList<String> wordList){

        // Current Search
        String currentSearch = "";

        // For Each Letter in the Search Term
        for(char letter : searchTerm.toCharArray()){

            // Add the Letter to the Current Search String
            currentSearch += letter;

            // Update the Word List Based on the Current Search Term
            wordList = updateSearch(currentSearch, wordList);

            // Output Current Valid Terms List
            System.out.println("NARROWING LIST " + currentSearch + ": " + wordList);

        }

        // Return the List of Valid Terms
        return wordList;

    }

    public static ArrayList<String> updateSearch(String searchPart, ArrayList<String> currentValidList){

        // Stores the Valid List
        ArrayList<String> newValidList = new ArrayList<>();

        // For Each Word in the Valid Words List,
        for(String word : currentValidList){

            // If the Word in the Valid Word List Contains the Current Search Part...
            if(word.toLowerCase().contains(searchPart.toLowerCase())){

                // Add it to the New Valid List
                newValidList.add(word);

            }

        }

        // Return the New Valid List
        return newValidList;

    }

}
