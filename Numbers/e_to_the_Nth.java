package Numbers;

/**
 * Program: e to the Nth Place
 * Programmer: Harsha Kuchampudi
 * Date: May 16, 2015
 *
 * Description: Queries the user on how many places to round e
 * to and then provides the correct rounding result from 1-18 places
 */

import java.util.Scanner;

public class e_to_the_Nth {

    public static void main(String []args){

        // Scanner Creation
        Scanner input = new Scanner(System.in);

        // User Dialogue
        System.out.print("How many digits do you want to round e to: ");

        // Get User Input
        long numberRound = input.nextInt();

        // Calculate the Rounding Multiplier and the Rounded Number
        long multiplier = (long) Math.pow(10, numberRound);
        double roundedNumber = (double) Math.round(Math.E * multiplier) / multiplier;

        // Output the Rounded Number
        System.out.print(roundedNumber);

        // Close the Scanner
        input.close();

    }

}
