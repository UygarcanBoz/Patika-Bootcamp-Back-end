import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number of steps from the user
        System.out.print("Number of Steps: ");
        int stepCount = input.nextInt();

        // Draw the inverted triangle
        for (int i = 0; i < stepCount; i++) {
            // Add spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // Add stars
            for (int k = 0; k < 2 * (stepCount - i) - 1; k++) {
                System.out.print("*");
            }

            // Move to the next line
            System.out.println();
        }

        input.close();
    }
}