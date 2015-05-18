package Numbers;

/**
 * Program: Happy Numbers
 * Programmer: Harsha Kuchampudi
 * Date: May 18, 2015
 *
 * Description: A happy number is defined by the following process.
 * Starting with any positive integer, replace the number by the sum
 * of the squares of its digits, and repeat the process until the number
 * equals 1 (where it will stay), or it loops endlessly in a cycle which
 * does not include 1. Those numbers for which this process ends in 1
 * are happy numbers, while those that do not end in 1 are unhappy numbers.
 */

import java.util.*;

public class happy_numbers {

    public static void main(String []args){

        // Happy Number Container
        ArrayList<Integer> happyNumbers = new ArrayList<>();
        int counter = 1;

        // Scanner Creation
        Scanner input = new Scanner(System.in);

        // User Interaction Dialogue
        System.out.print("How Many Happy Numbers Would You Like: ");
        int userInteger = input.nextInt();

        // Loop to Get the Amount of Happy Numbers Requested
        while(happyNumbers.size() < userInteger){

            if(isHappy(counter)) happyNumbers.add(counter);

            counter += 1;

        }

        // Output
        System.out.print(happyNumbers);

    }

    public static boolean isHappy(int number){

        // Storage for the New Numbers that Have Been Created
        List<Integer> newNumber_History = new ArrayList<>();

        // Initialization of New Number Storage
        int newNumber = 0;

        // While the Number is Non-Happy and Non-Repeating...
        while(newNumber != 1) {

            // Reset the New Number Storage
            newNumber = 0;

            // Calculate the New Number
            while (number > 0) {

                int digit = number % 10;

                newNumber += Math.pow(digit, 2);

                number = number / 10;

            }

            // Update the Number to the New Number
            number = newNumber;

            // Add the New Number to the Number History
            newNumber_History.add(newNumber);

            // Loop Check
            boolean looping = isLooping(newNumber_History);

            // Return that the Number is Not Happy if Looping is Found
            if(looping) return false;

        }

        return true;

    }

    public static boolean isLooping(List<Integer> numberHistory){

        // Get the Set of Unique Values
        Set<Integer> uniqueNumbers = new HashSet<Integer>(numberHistory);

        // If the Set of Unique Numbers is Not the Same Size as the Number
        // History List, A Number has Been Repeated. That Number Will Deconstruct
        // the Same Way it has Done in the Past. Therefore, a Non-Unique Number
        // is a Loop Indicator
        return uniqueNumbers.size() != numberHistory.size();

    }

}
