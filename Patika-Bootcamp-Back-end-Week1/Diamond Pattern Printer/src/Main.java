import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the diamond from the user
        System.out.print("Enter the size of the diamond: ");
        int size = scanner.nextInt();

        // Create the upper half of the diamond
        for (int i = 1; i <= size; i += 2) {
            // Print spaces before the stars
            for (int j = 0; j < size - i / 2; j++) {
                System.out.print(" ");
            }
            // Print the stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }

        // Create the lower half of the diamond
        for (int i = size - 2; i >= 1; i -= 2) {
            // Print spaces before the stars
            for (int j = 0; j < size - i / 2; j++) {
                System.out.print(" ");
            }
            // Print the stars
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }

        scanner.close();
    }
}