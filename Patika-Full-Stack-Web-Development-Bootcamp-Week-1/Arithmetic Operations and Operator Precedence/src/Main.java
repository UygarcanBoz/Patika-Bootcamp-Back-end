import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating Scanner object for user input.
        Scanner input = new Scanner(System.in);

        // Getting three numbers from the user.
        System.out.print("Enter the first number (a): ");
        double a = input.nextDouble();

        System.out.print("Enter the second number (b): ");
        double b = input.nextDouble();

        System.out.print("Enter the third number (c): ");
        double c = input.nextDouble();

        // Performing the calculation: a + b * c - b
        double result = a + b * c - b;

        // Printing the result.
        System.out.println("The result of the calculation is: " + result);


        input.close();
    }
}