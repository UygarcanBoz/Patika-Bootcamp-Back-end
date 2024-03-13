/**
 * This program takes an integer input 'N' from the user and generates a sequence
 * of numbers based on the following rule:
 * 1. Start with the given number 'N'.
 * 2. Subtract 5 until the number becomes 0 or negative.
 * 3. Add 5 until the number becomes equal to the original 'N'.
 * 4. Print each number in the sequence.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        // Get user input for the initial value 'N'.
        System.out.print("Enter the value of N: ");
        int N = inp.nextInt();

        // Display the original value of 'N'.
        System.out.print("Output: ");

        // Call the recursive methods to generate and print the sequence.
        patternMinus(N, N);

        inp.close();
    }

    /**
     * Recursive method to generate and print the sequence in decreasing order based on the specified rule.
     * @param current    The current value of 'N'.
     * @param original   The original value of 'N'.
     * @return The final value in the sequence.
     */
    static int patternMinus(int current, int original) {
        System.out.print(current + " ");
        if (current > 0) {
            current -= 5;
            return patternMinus(current, original);
        } else {
            return patternPlus(current, original);
        }
    }

    /**
     * Recursive method to generate and print the sequence in increasing order based on the specified rule.
     * @param current    The current value of 'N'.
     * @param original   The original value of 'N'.
     * @return The final value in the sequence.
     */
    static int patternPlus(int current, int original) {
        if (current < original) {
            current += 5;
            System.out.print(current + " ");
            return patternPlus(current, original);
        } else {
            return current;
        }
    }
}