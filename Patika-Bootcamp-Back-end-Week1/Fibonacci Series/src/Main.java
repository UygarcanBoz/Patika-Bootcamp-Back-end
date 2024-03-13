import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the number of elements for the Fibonacci series
        System.out.print("Enter the number of elements for the Fibonacci series: ");
        int n = input.nextInt();

        // Display the Fibonacci series
        System.out.println(n + " Element Fibonacci Series:");

        // Calculate and print the Fibonacci series
        int first = 0, second = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }

        input.close();
    }
}