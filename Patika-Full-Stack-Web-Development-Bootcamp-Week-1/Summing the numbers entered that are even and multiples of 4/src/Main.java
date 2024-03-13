import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an odd number to stop the program
        System.out.println("To stop the program, enter an odd number.");

        // Variable to store the sum of even numbers that are multiples of 4
        int sum = 0;

        // Continue accepting input until an odd number is entered
        while (true) {
            // Prompt the user to enter a number
            System.out.print("Enter a number: ");
            int number = input.nextInt();

            // Break the loop if an odd number is entered
            if (number % 2 != 0) {
                break;
            }

            // Add even numbers that are multiples of 4 to the sum
            if (number % 2 == 0 && number % 4 == 0) {
                sum += number;
            }
        }

        // Display the sum of entered even numbers that are multiples of 4
        System.out.println("Sum of entered even numbers that are multiples of 4: " + sum);

        // Close the scanner
        input.close();
    }
}