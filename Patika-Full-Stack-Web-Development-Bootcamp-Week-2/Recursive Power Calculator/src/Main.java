import java.util.Scanner;

public class Main {

    /**
     * This program calculates the power of a base raised to an exponent using recursion.
     * It takes the base and exponent values from the user and displays the result.
     */

    // Recursive method to calculate exponentiation
    static int calculatePower(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * calculatePower(base, exponent - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("This program calculates the power of a base raised to an exponent using recursion.");

        // Taking input for base
        System.out.print("Enter the base value: ");
        int base = input.nextInt();

        // Taking input for exponent
        System.out.print("Enter the exponent value: ");
        int exponent = input.nextInt();

        // Calculating and displaying the result using the recursive method
        int result = calculatePower(base, exponent);
        System.out.println("Result: " + result);
    }
}