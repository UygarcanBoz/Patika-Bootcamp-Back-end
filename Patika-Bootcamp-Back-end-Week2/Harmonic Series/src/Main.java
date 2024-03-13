/**
 * This program calculates the arithmetic and harmonic means of user-input array elements.
 * The user is prompted to enter the number of elements and the individual elements.
 * The program then computes the arithmetic mean (average) and harmonic mean of the elements.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Create an array to store user-input elements
        int[] numbers = new int[n];

        // Input values from the user
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int sum = 0;
        double harmonicSum = 0.0;

        // Calculate the sum of the elements
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
        }

        // Calculate the harmonic sum
        for (int i = 0; i < n; i++) {
            harmonicSum += 1.0 / numbers[i];
        }

        // Calculate the harmonic mean
        double harmonicMean = n / harmonicSum;

        // Display the results
        System.out.println("Arithmetic Mean: " + (sum / (double) n));
        System.out.println("Harmonic Mean: " + harmonicMean);
    }
}