import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int limit = input.nextInt();

        // Display the powers of 4 and 5 up to the entered number
        System.out.println("Powers of 4 and 5 up to " + limit + ":");

        // Iterate through numbers up to the entered limit
        for (int i = 1; i <= limit; i++) {
            // Calculate and display the powers of 4 and 5
            System.out.println("4^" + i + " = " + Math.pow(4, i) + "\t\t5^" + i + " = " + Math.pow(5, i));
        }

        input.close();
    }
}