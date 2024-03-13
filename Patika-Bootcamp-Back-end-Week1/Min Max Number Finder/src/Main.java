import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number of values to be entered
        System.out.print("How many numbers will you enter? ");
        int n = input.nextInt();

        // Initialize variables for minimum and maximum values
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Get numbers from the user and find the minimum and maximum
        for (int i = 1; i <= n; i++) {
            System.out.print(i + ". Enter a number: ");
            int number = input.nextInt();

            // Update min and max values
            if (number < min) {
                min = number;
            }

            if (number > max) {
                max = number;
            }
        }

        // Print the results
        System.out.println("Largest number: " + max);
        System.out.println("Smallest number: " + min);

        input.close();
    }
}
