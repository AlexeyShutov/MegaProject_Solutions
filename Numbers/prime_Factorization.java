package Numbers;

/**
 * Program: Prime Factorization
 * Programmer: Harsha Kuchampudi
 * Date: May 17, 2015
 *
 * Description: The user enters a number and
 * the program finds all Prime Factors (if there
 * are any) and displays them.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class prime_Factorization {

    public static void main(String []args){

        // Prime Factorization Storage
        ArrayList<Integer> primeStorage = new ArrayList<>();
        ArrayList<Integer> primeStorageOutput = new ArrayList<>();

        // User Input Dialogue
        System.out.print("Please Enter a Number to Determine its Prime Factors: ");

        // Scanner Creation
        Scanner input = new Scanner(System.in);
        int userNumberChoice = input.nextInt();

        // Prime Factorization if Valid Number
        if(userNumberChoice > 0) {

            // Prime Factorization
            primeStorageOutput = primeFactorize(userNumberChoice, primeStorage);

            // Output
            System.out.print(primeStorageOutput);

        }

        else{

            // Output
            System.out.print("Sorry, Please Use a Positive Number!");

        }

    }

    public static boolean isPrime(int number_to_Check){

        /** AKS Prime Algorithm: START **/
        // Basic Primes
        if(number_to_Check == 2) return true;
        if(number_to_Check == 3) return true;

        // Basic Prime Negation
        if(number_to_Check % 2 == 0) return false;
        if(number_to_Check % 3 == 0) return false;

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
        /** AKS Prime Algorithm: END **/

    }

    public static ArrayList<Integer> primeFactorize(int number_to_Factorize, ArrayList<Integer> factorization_Storage){

        // If the Number is Already Prime Add it to the Array
        if(isPrime(number_to_Factorize)) factorization_Storage.add(number_to_Factorize);

        // While the Number that Needs to Be Factorized is Not Prime...
        while(!isPrime(number_to_Factorize)){

            // Iterate to Find a Number that is Divisible to the Number to be Factorized
            for(int counter = 2; counter < number_to_Factorize; counter++){

                // If the Number is Divisible...
                if(number_to_Factorize % counter == 0){

                    // If the Divisor is Prime, but the Resultant Number is non-Prime...
                    if(isPrime(counter) && !isPrime(number_to_Factorize / counter)){

                        // Add the Divisor to the Prime Factorization List
                        factorization_Storage.add(counter);

                        // Factorize the Resultant Number
                        number_to_Factorize = number_to_Factorize / counter;

                    }

                    // If Both the Divisible Number and the Resultant Number are Prime..
                    else if(isPrime(counter) && isPrime(number_to_Factorize / counter)){

                        // Add Both of Them to the Prime Factorization List
                        factorization_Storage.add(counter);

                        factorization_Storage.add(number_to_Factorize / counter);

                        // Factorize the Resultant Number (The Resultant Number will be Prime and End the Loop)
                        number_to_Factorize = number_to_Factorize / counter;

                    }

                }

            }

        }

        // Return the List for the Prime Factorization for the User's Number
        return factorization_Storage;

    }

}
