import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get a number from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Calculate the sum of digits in the number
        int sum = 0;

        // Sum the digits of the number
        while (number != 0) {
            sum += number % 10;  // Take the last digit and add it to the sum
            number /= 10;        // Drop the last digit and move to the previous digit
        }

        System.out.println("Sum of digits = " + sum);

        scanner.close();
    }
}