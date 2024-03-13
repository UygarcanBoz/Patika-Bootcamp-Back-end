import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get a number from the user
        System.out.print("Enter a number (n): ");
        int n = input.nextInt();

        // Calculate the harmonic series and print the result
        double harmonicSum = 0.0;

        // Calculate the harmonic series
        for (int i = 1; i <= n; i++) {
            harmonicSum += 1.0 / i;
        }

        System.out.println("Harmonic series H(" + n + ") = " + harmonicSum);

        input.close();
    }
}