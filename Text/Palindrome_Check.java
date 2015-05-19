package Text;

/**
 * Program: Check if String is a Palindrome
 * Programmer: Harsha Kuchampudi
 * Date: May 18, 2015
 *
 * Description: Checks if the string entered by the user is a palindrome.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Palindrome_Check {

    public static void main(String []args){

        // Scanner Creation
        Scanner input = new Scanner(System.in);

        // User Interaction Dialogue
        System.out.print("Please Enter A String to Check if it is a Palindrome: ");
        String userInput = input.nextLine().toLowerCase().replace(" ", "");

        // Palindrome Check
        boolean palindromeCheck = isPalindrome(userInput);

        // Output
        System.out.println(palindromeCheck);

    }

    public static boolean isPalindrome(String inputString){

        // Input String to Character Array
        List<Character> inputCharList = new ArrayList<>();
        List<Character> reversedCharList = new ArrayList<>();

        // Add Letters to in the Input String to inputCharList and reversedCharList
        for(char letter : inputString.toCharArray()) inputCharList.add(letter);
        for(char letter : inputString.toCharArray()) reversedCharList.add(letter);

        // Reversed Input Character Array (reversedCharList)
        Collections.reverse(reversedCharList);

        // If Each Character in the Normal List is Not the Same as the Character in the Reversed List
        // Return that the String is Not a Palindrome (False)
        for(int counter = 0; counter < inputCharList.size(); counter++){
            if(inputCharList.get(counter) != reversedCharList.get(counter)) return false;

        }

        // Return True if is Palindrome
        return true;

    }

}
