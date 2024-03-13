/**
 * A Java program that uses a recursive method to calculate Fibonacci series.
 * The Fibonacci series is a series of numbers where each number is the sum of the two preceding ones.
 * The program takes the index of the Fibonacci series element as input and prints the series.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the index of the Fibonacci series element: ");
        int index = input.nextInt();

        System.out.print("Fibonacci series: ");
        for (int i = 0; i <= index; i++) {
            System.out.print(calculateFibonacci(i) + " ");
        }

        input.close();
    }

    /**
     * Recursive method to calculate Fibonacci series element.
     * @param index The index of the Fibonacci series element to be calculated.
     * @return The value of the Fibonacci series element at the specified index.
     */
    static int calculateFibonacci(int index) {
        if (index <= 1) {
            return index;
        } else {
            return calculateFibonacci(index - 1) + calculateFibonacci(index - 2);
        }
    }
}