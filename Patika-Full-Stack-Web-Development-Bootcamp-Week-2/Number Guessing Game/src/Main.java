/**
 * This program implements a simple number guessing game where the user tries to guess
 * a randomly selected number between 0 and 100 (inclusive). The user has 5 chances to guess the correct number.
 * After each incorrect guess, the program provides hints about whether the correct number
 * is greater or smaller than the guessed number.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Generate a random number between 0 and 100 (inclusive)
        Random rand = new Random();
        int number = rand.nextInt(101);

        Scanner input = new Scanner(System.in);
        int right = 0;           // Number of correct guesses
        int selected;            // User's selected number
        int[] wrong = new int[5]; // Array to store incorrect guesses
        boolean isWin = false;    // Flag to track if the user has won
        boolean isWrong = false;  // Flag to track if the user made a wrong input

        // Main game loop
        while (right < 5) {
            System.out.print("Enter your guess: ");
            selected = input.nextInt();

            // Check if the input is within the valid range
            if (selected < 0 || selected > 100) {
                System.out.println("Please enter a value between 0 and 100 (inclusive).");
                // Check if the user has made too many wrong inputs
                if (isWrong) {
                    right++;
                    System.out.println("Too many incorrect inputs. Remaining chances: " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("One more incorrect input will reduce your chances.");
                }
                continue; // Skip the rest of the loop and start a new iteration
            }

            // Check if the selected number is correct
            if (selected == number) {
                System.out.println("Congratulations! You guessed the correct number: " + number);
                isWin = true;
                break; // Exit the loop since the correct number is guessed
            } else {
                System.out.println("Incorrect guess!");
                // Provide hints about whether the correct number is greater or smaller
                if (selected > number) {
                    System.out.println(selected + " is greater than the hidden number.");
                } else {
                    System.out.println(selected + " is smaller than the hidden number.");
                }

                // Store the incorrect guess and update the chances
                wrong[right++] = selected;
                System.out.println("Remaining chances: " + (5 - right));
            }
        }

        // Display the result if the user did not win
        if (!isWin) {
            System.out.println("Game over! You lost.");
            // Display the incorrect guesses if the user didn't make too many wrong inputs
            if (!isWrong) {
                System.out.println("Your guesses: " + Arrays.toString(wrong));
            }
        }
    }
}