import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaring variables to store the two numbers needed for calculation.
        double number1, number2;

        // Creating a Scanner object to take input from the user.
        Scanner input = new Scanner(System.in);

        // Getting the first number from the user.
        System.out.print("Enter the first number: ");
        number1 = input.nextDouble();

        // Getting the second number from the user.
        System.out.print("Enter the second number: ");
        number2 = input.nextDouble();

        // Getting an operator input from the user (+, -, *, /).
        System.out.print("Enter the operator (+, -, *, /): ");
        char operator = input.next().charAt(0); // Since we are looking for one character, value inside charAt() is zero

        // Initializing the result variable.
        double result = 0.0;

        // Using switch statement to perform the calculation based on the operator.
        switch (operator) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                // Checking if the second number is not zero before performing the division.
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    // If the second number is zero, this line prints an error message and exit the program.
                    System.out.print("Cannot divide by zero.");
                    return;
                }
                break;
            default:
                // If the user enters an invalid operator, this line prints an error message and exit the program.
                System.out.print("Invalid operator.");
                return;
        }

        // Displaying the result of the calculation.
        System.out.print("Result: " + result);

        // Closing the Scanner object to prevent resource leaks.
        input.close();
    }
}