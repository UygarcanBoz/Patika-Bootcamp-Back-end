import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the base and exponent values from the user
        System.out.print("Enter the base: ");
        int base = input.nextInt();

        System.out.print("Enter the exponent: ");
        int exponent = input.nextInt();

        // Calculate the exponentiation and print the result
        long result = 1;

        // Calculate exponentiation using a loop
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println(base + "^" + exponent + " = " + result);

        input.close();
    }
}