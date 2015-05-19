package Text;

/**
 * Program: Reverse a String
 * Programmer: Harsha Kuchampudi
 * Date: May 18, 2015
 *
 * Description: Enter a string and the program will
 * reverse it and print it out.
 */

import java.util.Scanner;

public class Reverse_String {

    public static void main(String []args){

        // Create Scanner
        Scanner input = new Scanner(System.in);

        // User Interaction Dialogue
        System.out.print("Please Enter the String You Want to Reverse: ");
        String userInput = input.nextLine();

        // Reverse String
        String reversedString = reverseString(userInput);

        // Output
        System.out.println(reversedString);

    }

    public static String reverseString(String inputString){

        // Character Array that the Input String is Converted Into
        char[] characterArray = inputString.toCharArray();

        // Storage for the Reversed String
        String reversedString = "";

        // For Each Character in the Input String, Traverse the Array
        // From Back to Front and Add the Character to the Reversed String
        for(int counter = characterArray.length - 1; counter >= 0; counter--){
            reversedString += characterArray[counter];

        }

        // Return the Reversed String
        return reversedString;

    }

}
