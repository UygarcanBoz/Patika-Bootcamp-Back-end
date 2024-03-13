import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double radius, angle, pi = 3.14;

        Scanner input = new Scanner(System.in);

        // Getting the radius and central angle from the user.
        System.out.print("Enter the radius (r): ");
        radius = input.nextDouble();
        System.out.print("Enter the central angle (in degrees): ");
        angle = input.nextDouble();

        // Calculating the area of a sector of circle with the given formula.
        double area = (angle * pi * radius * radius) / 360;

        System.out.print("The area of the sector is:  " + area);

        input.close();
    }
}