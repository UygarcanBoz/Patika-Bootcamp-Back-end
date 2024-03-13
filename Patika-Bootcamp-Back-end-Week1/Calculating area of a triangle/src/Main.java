import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaring variables.
        double side1, side2, side3;

        // Creating a Scanner object for user inputs.
        Scanner scanner = new Scanner(System.in);

        // Getting the lengths of the three sides.
        System.out.print("Enter the length of side 1: ");
        side1 = scanner.nextDouble();

        System.out.print("Enter the length of side 2: ");
        side2 = scanner.nextDouble();

        System.out.print("Enter the length of side 3: ");
        side3 = scanner.nextDouble();

        // Calculating the semi-perimeter of the triangle.
        double semiPerimeter = (side1 + side2 + side3) / 2;

        // Calculating the area of the triangle.
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));

        System.out.println("The area of the triangle is: " + area);

        scanner.close();
    }
}