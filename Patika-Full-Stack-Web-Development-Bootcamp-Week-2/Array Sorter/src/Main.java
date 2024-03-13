/**
 * This program takes an array size and its elements from the user,
 * sorts the elements in ascending order, and displays the sorted array.
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array (n): ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". Element: ");
            array[i] = scanner.nextInt();
        }

        // Sort the array
        Arrays.sort(array);

        // Display the sorted array
        System.out.print("Sorted Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
