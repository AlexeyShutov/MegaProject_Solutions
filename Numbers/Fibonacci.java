package Numbers;

/**
 * Program: Fibonacci Sequence
 * Programmer: Harsha Kuchampudi
 * Date: May 16, 2015
 *
 * Description: Enter a number and have the program generate
 * the Fibonacci sequence to the Nth number.
 */

import java.util.Scanner;

public class Fibonacci {

    public static void main(String []args){

        // Scanner Declaration
        Scanner input = new Scanner(System.in);

        // User Dialogue
        System.out.print("What Limit Would You Like the Fibonacci to Go Up To: ");
        int endLimit = input.nextInt();

        // Function that prints out the Fibonacci Sequence to the User
        // Defined Limit
        int ending_value = fibonacci(0,1,endLimit);

    }

    public static int fibonacci(int number1, int number2, int ending) {

        // Fibonacci Addition
        int number3 = number1 + number2;

        // Fibonacci Continuation
        if (number3 <= ending) {

            // Fibonacci Recursion
            number1 = number2;
            number2 = number3;
            System.out.print(number2 + ", ");
            return fibonacci(number1, number2, ending);

        }

        // Return Final
        return ending;

    }

}
