package Numbers;

/**
 * Program: Binary-Decimal Conversion
 * Programmer: Harsha Kuchampudi
 * Date: May 17, 2015
 *
 * Description: A converter to convert a decimal
 * number to binary or a binary number to its decimal
 * equivalent.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class binary_decimal_conversion {

    public static void main(String []args){

        // Create Scanner
        Scanner input = new Scanner(System.in);

        // User Interaction Dialogue
        System.out.print("Would you Like to Convert (1) Decimal to Binary or (2) Binary to Decimal? (1|2): ");
        int userChoice = input.nextInt();

        // If Decimal -> Binary Conversion is Chosen,
        // Run the Correct Conversion Program
        if(userChoice == 1){
            decimalBinary_conversion();
        }

        // If Binary -> Decimal Conversion is Chosen...
        // Run the Correct Conversion Program
        else if(userChoice == 2){
            binaryDecimal_conversion();
        }

        // Any Other Input...
        else{

            // Output Error
            System.out.println("Sorry, Unrecognized Choice!");

        }

    }

    public static void binaryDecimal_conversion(){

        // Scanner Creation
        Scanner input = new Scanner(System.in);

        // User Interaction Dialogue
        System.out.print("Please Enter the Binary Number: ");
        String binaryNumber = input.next();

        // Gets the Length of the Binary Number and Assigns the Index Value to Start With
        int binaryNumber_Length = binaryNumber.length();
        int binaryNumber_Index = binaryNumber.length() - 1;

        // Stores the Decimal Value of the Binary Number
        int decimalValue = 0;

        // Iterates Through the Digits in the Binary Number and Adds Each Component of the
        // Decimal Number to the Decimal Value Storage
        for(int counter = 0; counter < binaryNumber_Length; counter++){
            int currentNumber = Character.getNumericValue(binaryNumber.charAt(counter));
            int decimalPart = currentNumber * (int) Math.pow(2, binaryNumber_Index);
            decimalValue += decimalPart;

            // Decrement the Index for the Next Binary Digit
            binaryNumber_Index -= 1;
        }

        // Output
        System.out.print("Your Number in Decimal Format: " + decimalValue);

    }

    public static void decimalBinary_conversion(){

        // ArrayList to Store the Components of the Binary Number
        ArrayList<Integer> binaryComponents = new ArrayList<>();

        // Scanner Creation
        Scanner input = new Scanner(System.in);

        // User Interaction Dialogue
        System.out.print("Please Enter the Decimal Number: ");
        int decimalNumber = input.nextInt();

        // Calculate the Binary Equivalent
        while(decimalNumber != 0){

            // Calculate the Remainder
            int remainder = decimalNumber % 2;

            // Add the Remainder to the List
            binaryComponents.add(remainder);

            // Assign the New Divided Value to decimalNumber
            decimalNumber = decimalNumber / 2;

        }

        // Reverse the Array
        Collections.reverse(binaryComponents);

        // Convert to an Array
        binaryComponents.toArray();

        // Output
        System.out.print("Your Binary Number is: ");

        for(int number : binaryComponents){
            System.out.print(number);
        }

    }

}
