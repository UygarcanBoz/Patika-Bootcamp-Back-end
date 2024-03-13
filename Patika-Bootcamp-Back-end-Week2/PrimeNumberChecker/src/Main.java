/**
 * This program checks if a given number is prime using recursion.
 * It prompts the user to enter a number and displays whether it is prime or not.
 */

import java.util.Scanner;

public class Main {

    // Recursive method to check if a number is prime
    static boolean isPrime(int number, int divisor) {
        if (divisor == 1) {
            return true;
        } else {
            if (divisor != 0 && number % divisor == 0) {
                return false;
            } else {
                return isPrime(number, divisor - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking input for the number
        System.out.print("Enter a number to check if it is prime: ");

        int number = input.nextInt();

        // Checking if the number is prime using the recursive method
        boolean isPrime = isPrime(number, number / 2);

        // Displaying the result
        if (isPrime) {
            System.out.println(number + " is a PRIME number!");
        } else {
            System.out.println(number + " is NOT a prime number!");
        }
    }
}