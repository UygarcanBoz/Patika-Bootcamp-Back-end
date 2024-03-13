import java.util.Scanner;

/**
 * This program finds the minimum and maximum values in a given array.
 * Additionally, it finds the closest smaller and larger numbers to a user-input value.
 */
public class Main {
    public static void main(String[] args) {
        int[] list = {15, 12, 788, 1, -1, -778, 2, 0};

        // Find minimum and maximum values in the array
        int min = list[0];
        int max = list[0];

        for (int i : list) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }

        // Display minimum and maximum values
        System.out.println("Minimum Value: " + min);
        System.out.println("Maximum Value: " + max);

        // Find the closest smaller and larger numbers to a user-input value
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int userInput = scanner.nextInt();

        int closestSmaller = findClosestSmaller(list, userInput);
        int closestLarger = findClosestLarger(list, userInput);

        // Display the results
        System.out.println("Closest Smaller Value: " + closestSmaller);
        System.out.println("Closest Larger Value: " + closestLarger);
    }

    // Method to find the closest smaller number in the array
    private static int findClosestSmaller(int[] array, int target) {
        int closestSmaller = Integer.MIN_VALUE;

        for (int value : array) {
            if (value < target && value > closestSmaller) {
                closestSmaller = value;
            }
        }

        return closestSmaller;
    }

    // Method to find the closest larger number in the array
    private static int findClosestLarger(int[] array, int target) {
        int closestLarger = Integer.MAX_VALUE;

        for (int value : array) {
            if (value > target && value < closestLarger) {
                closestLarger = value;
            }
        }

        return closestLarger;
    }
}
