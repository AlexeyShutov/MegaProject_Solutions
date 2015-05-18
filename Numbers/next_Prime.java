package Numbers;

/**
 * Program: Next Prime Number
 * Programmer: Harsha Kuchampudi
 * Date: May 16, 2015
 *
 * Description: Gives the User the Next Prime Number
 * Until User Specifies to Stop
 */

import java.util.Scanner;

public class next_Prime {

    public static void main(String []args){

        // Scanner Creation
        Scanner input = new Scanner(System.in);

        // Storage for User Choice
        String userChoice = "YES";

        // Prime Starting Number
        int primeNumber = 0;

        // While the User Wants the Next Prime
        while(userChoice.equals("YES")) {

            // Increment Away from Last Prime
            primeNumber += 1;

            // Generate the Next Prime
            while(!isPrime(primeNumber)){
                primeNumber += 1;
            }

            // Output Prime
            System.out.println("Here is Your Prime: " + primeNumber);

            // User Interaction Dialogue
            System.out.print("Would You Like the Next Prime? (YES|NO): ");
            userChoice = input.next().toUpperCase();

        }

    }

    public static boolean isPrime(int number_to_Check){

        // Basic Primes
        if(number_to_Check == 2) return true;
        if(number_to_Check == 3) return true;

        // Basic Prime Negation
        if(number_to_Check % 2 == 0) return false;
        if(number_to_Check % 3 == 0) return false;

        /** AKS Prime Algorithm **/
        int number1 = 5;
        int number2 = 2;

        while(number1 * number1 <= number_to_Check){
            if(number_to_Check % number1 == 0){
                return false;
            }

            number1 += number2;
            number2 = 6 - number2;
        }

        return true;

    }

}
