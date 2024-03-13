import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get values of n and r from the user
        System.out.print("Enter the value of n: ");
        int n = input.nextInt();

        System.out.print("Enter the value of r: ");
        int r = input.nextInt();

        // Calculate combination and print the result
        long combination = 1;

        // Calculate combination using a loop
        for (int i = 1; i <= r; i++) {
            combination *= n - i + 1;
            combination /= i;
        }

        System.out.println("C(" + n + ", " + r + ") = " + combination);

        input.close();
    }
}