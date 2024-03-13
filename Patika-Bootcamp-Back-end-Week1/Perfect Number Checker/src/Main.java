import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get a number from the user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check if the number is a perfect number
        boolean isPerfect = false;

        if (number > 1) {
            int sum = 1;

            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    sum += i;
                    if (i != number / i) {
                        sum += number / i;
                    }
                }
            }

            isPerfect = (sum == number);
        }

        // Print the result
        if (isPerfect) {
            System.out.println(number + " is a perfect number.");
        } else {
            System.out.println(number + " is not a perfect number.");
        }

        input.close();
    }
}