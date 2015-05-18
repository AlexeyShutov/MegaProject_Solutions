package Numbers;

import java.util.Scanner;

/**
 * Program: Factorial Finder
 * Programmer: Harsha Kuchampudi
 * Date: May 18, 2015
 *
 * Description: The Factorial of a positive integer, n, is defined
 * as the product of the sequence n, n-1, n-2, ...1 and the factorial
 * of zero, 0, is defined as being 1.
 */

public class factorial_finder {

    public static void main(String []args){

        // Scanner Creation
        Scanner input = new Scanner(System.in);

        // User Interaction Dialogue
        System.out.print("What Number Would You Like to Take the Factorial of?: ");
        int userNumber = input.nextInt();

        // Find the Factorial Value
        long factorial = factorial(userNumber);

        // Output
        System.out.println(factorial);

    }

    public static long factorial(int number){

        if(number == 0) return 1;

        return number * factorial(number - 1);

    }

}
