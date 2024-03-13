import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get two numbers from the user
        System.out.print("Enter the first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int number2 = input.nextInt();

        // Calculate GCD (EBOB) and LCM (EKOK)
        int a = number1, b = number2;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        int gcd = a;
        int lcm = (number1 * number2) / gcd;

        System.out.println("GCD (EBOB) of " + number1 + " and " + number2 + ": " + gcd);
        System.out.println("LCM (EKOK) of " + number1 + " and " + number2 + ": " + lcm);

        input.close();
    }
}