import java.util.Arrays;
import java.util.Scanner;

/**
 * This program calculates the frequency of each element in an array without using HashMap.
 * The user inputs the array size and elements from the keyboard.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the array size from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Create an array to store elements
        int[] array = new int[size];

        // Get array elements from the user
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Sort the array to simplify frequency calculation
        Arrays.sort(array);

        // Calculate the frequency of each element
        int currentElement = array[0];
        int count = 1;

        System.out.println("Frequency of Elements:");

        for (int i = 1; i < array.length; i++) {
            if (array[i] == currentElement) {
                count++;
            } else {
                System.out.println(currentElement + " appeared " + count + " times.");
                currentElement = array[i];
                count = 1;
            }
        }

        // Display the frequency of the last element
        System.out.println(currentElement + " appeared " + count + " times.");

        // Close the scanner to prevent resource leak
        scanner.close();
    }
}
