package Classic_Algorithms;

import java.util.Scanner;

/**
 * Program: Collatz Conjecture
 * Programmer: Harsha Kuchampudi
 * Date: May 18, 2015
 *
 * Description: Start with a number n > 1. Find the
 * number of steps it takes to reach one using the
 * following process: If n is even, divide it by 2.
 * If n is odd, multiply it by 3 and add 1.
 */

public class Collatz_Conjecture{

    public static void main(String []args){

        // Scanner Setup
        Scanner input = new Scanner(System.in);

        // User Interaction Dialogue
        System.out.print("Please Enter a Number You Wish to Apply Collatz's Conjecture to: ");
        int userInput = input.nextInt();

        // Apply Collatz's Conjecture if Number is Valid
        if (userInput > 1) System.out.print("The Number of Steps Needed: " + collatzConjecture(userInput, 0));

        // Otherwise Show Error
        else System.out.print("ERROR!");

    }

    public static int collatzConjecture(int number, int steps_taken){

        if (number == 1) return steps_taken;

        if (number % 2 == 0) return collatzConjecture((number / 2), steps_taken + 1);

        if (number % 2 != 0) return collatzConjecture(((number * 3) + 1), steps_taken + 1);

        return steps_taken;

    }

}