import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get an integer input from the user
        System.out.print("Enter an integer: ");
        int intNumber = input.nextInt();

        // Get a floating-point number input from the user
        System.out.print("Enter a decimal number: ");
        double doubleNumber = input.nextDouble();

        // Convert integer to double and print the result
        double convertedToInt = (double) intNumber;
        System.out.println("When we convert the integer to a decimal number: " + convertedToInt);

        // Convert double to integer and print the result
        int convertedToDouble = (int) doubleNumber;
        System.out.println("When we convert the decimal number to an integer: " + convertedToDouble);

        input.close();
    }
}