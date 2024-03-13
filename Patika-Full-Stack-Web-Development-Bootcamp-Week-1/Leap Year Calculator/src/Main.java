import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the year from the user
        System.out.print("Enter the year: ");
        int year = input.nextInt();

        // Leap year check and print the result message accordingly
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        input.close();
    }
}