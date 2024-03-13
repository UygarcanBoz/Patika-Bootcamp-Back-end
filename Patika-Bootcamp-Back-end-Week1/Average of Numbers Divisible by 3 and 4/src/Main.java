import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompting the user to enter a number
        System.out.print("Enter a number: ");
        int limit = input.nextInt();

        // Checking for negative number
        if (limit < 0) {
            System.out.println("Please enter a non-negative number.");
        } else {
            // Sum of numbers divisible by 3 and 4
            int sum = 0;

            // Counter for numbers divisible by 3 and 4
            int count = 0;

            // Iterating through numbers from 0 to the limit
            for (int i = 0; i <= limit; i++) {
                // Checking for numbers divisible by both 3 and 4
                if (i % 3 == 0 && i % 4 == 0) {
                    sum += i;    // Update the sum
                    count++;     // Increment the counter
                }
            }

            // Avoiding division by zero error
            double average = (count != 0) ? (double) sum / count : 0;

            // Displaying the result
            System.out.println("Average of numbers divisible by 3 and 4 between 0 and " + limit + ": " + average);
        }

        input.close();
    }
}