import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Getting three numbers from the user
        System.out.print("Enter the first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = input.nextInt();

        System.out.print("Enter the third number: ");
        int num3 = input.nextInt();

        // Sorting the numbers in ascending order and printing them
        if (num1 <= num2 && num1 <= num3) {
            if (num2 <= num3) {
                System.out.println("Sorted Order: " + num1 + ", " + num2 + ", " + num3);
            } else {
                System.out.println("Sorted Order: " + num1 + ", " + num3 + ", " + num2);
            }
        } else if (num2 <= num1 && num2 <= num3) {
            if (num1 <= num3) {
                System.out.println("Sorted Order: " + num2 + ", " + num1 + ", " + num3);
            } else {
                System.out.println("Sorted Order: " + num2 + ", " + num3 + ", " + num1);
            }
        } else {
            if (num1 <= num2) {
                System.out.println("Sorted Order: " + num3 + ", " + num1 + ", " + num2);
            } else {
                System.out.println("Sorted Order: " + num3 + ", " + num2 + ", " + num1);
            }
        }

        input.close();
    }
}