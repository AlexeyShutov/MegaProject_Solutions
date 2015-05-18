package Numbers;

/**
 * Program: Credit Card Validation Tool
 * Programmer: Harsha Kuchampudi
 * Date: May 17, 2015
 *
 * Description: A validation tool that returns true if an entered credit card number
 * is valid, and false if it is invalid.This program replicates components of Hans Luhn's
 * credit card validation algorithm.
 */

import java.util.Scanner;

public class Creditcard {

    public static void main(String []args){

        //Scanner Initialize
        Scanner input = new Scanner(System.in);

        //User Input
        System.out.print("Please Enter A Credit Card Number: ");
        long creditcard = input.nextLong();

        //Display Result
        System.out.print(isValid(creditcard));

        //Scanner Close
        input.close();

    }

    public static Boolean isValid(long number){

        //Prefix Fetch
        int prefix1 = (int) getPrefix(number,1);
        int prefix2 = (int) getPrefix(number,2);

        //Credit Card Validation Stage 1:
        if((sumOfDoubleEvenPlace(number) + sumOfoddPlace(number)) % 10 == 0){

            //Credit Card Validation Stage 2:
            if (getSize(number) == 16){

                //Credit Card Validation Stage 3:
                if(prefix1 == 4 || prefix1 == 5 || prefix1 == 6 || prefix2 == 37){

                    return true;

                }

                else return false;

            }

            else return false;

        }

        else return false;

    }

    public static int sumOfDoubleEvenPlace(long number){

        //Turns Number to String
        String number_string = Long.toString(number);

        //Gets Number of Credit Card Digits
        int number_length = number_string.length();

        //Stores Sum of the Double Even Place
        int sum1 = 0;

        //Backward Two Iterator
        for (int counter = number_length - 2; counter >= 0; counter -= 2){
            int reverse_number1 = Character.getNumericValue(number_string.charAt(counter));
            int doublereverse = 2 * reverse_number1;
            sum1 += getDigit(doublereverse);

        }

        //Returns the Calculated Sum
        return sum1;

    }

    public static int getDigit(int number){

        //Sum Storage Initialization
        int sum = 0;

        //Double Digit Check: FAIL
        if(number < 10){

            //Just Add Number to Sum
            sum = (number);

        }

        //Double Digit Check: PASS
        else if (number >= 10){

            //Break the Number Down and Add the Sums of the Components
            String numberstring = Integer.toString(number);
            int number1 = Character.getNumericValue(numberstring.charAt(0));
            int number2 = Character.getNumericValue(numberstring.charAt(1));
            sum = (number1 + number2);

        }

        //Returns the Single Number or the Sum of the Two Digits
        return sum;

    }

    public static int  sumOfoddPlace(long number){

        //Turns Number to String
        String number_string = Long.toString(number);

        //Gets Number of Credit Card Digits
        int number_length = number_string.length();

        //Initializes the Storage for the Sum of the Odd Places
        int sum2 = 0;

        // Adds Every Odd Place to the Sum
        for (int counter = number_length - 1; counter >= 0; counter -= 2){
            int reverse_number2 = Character.getNumericValue(number_string.charAt(counter));
            sum2 += reverse_number2;

        }

        //Returns the Calculated Sum
        return sum2;

    }

    public static boolean  prefixMatched(long number, int d){

        //Initializes the Boolean for if the Match is True or False
        boolean match = false;

        //Converts 'number' to String and Calculates the Number of Digits in 'number'
        String number_string = Long.toString(number);
        int number_length = number_string.length();

        //Converts 'd' to String and Calculates the Number of Digits in 'd'
        String number_stringd = Integer.toString(d);
        int number_lengthd = number_stringd.length();

        //Iterates through the First 'd' Digits
        for (int counter = 0; counter <= number_lengthd - 1; counter++){

            //If the First 'd' Digits Don't Match:
            if(number_string.charAt(counter) != number_stringd.charAt(counter)){
                match = false;

            }

            //If the Prefixes DO Match:
            else {match = true;}

        }

        //Return if the Prefixes Match
        return match;

    }

    public static int  getSize(long d){

        //Turns 'd' Into a String
        String number_string = Long.toString(d);

        //Returns the Number of Digits (chars) in the Number
        return (number_string.length());

    }

    public static long getPrefix(long number, int k){

        //Initializes StringBuilder to Combine Chars
        StringBuilder sb = new StringBuilder();

        //Converts 'number' to String
        String number_string = Long.toString(number);

        //Iterates through the Specified Number of digits 'k'
        for (int counter = 0; counter <= k - 1; counter++){

            //Adds the Character to StringBuilder
            char characterbuilder = number_string.charAt(counter);
            sb.append(characterbuilder);

        }

        //Converts StringBuilder to String
        String prefixstring = sb.toString();

        //Parses String to Integer and Returns the Result
        return (Integer.parseInt(prefixstring));

    }

}
