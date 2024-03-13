/**
 * The Main class demonstrates the Employee class by taking input from the user
 * for an employee's details and then displaying the calculated salary information.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get employee information from the user
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter weekly work hours: ");
        int workHours = scanner.nextInt();

        System.out.print("Enter hire year: ");
        int hireYear = scanner.nextInt();

        // Create an employee object
        Employee employee = new Employee(name, salary, workHours, hireYear);

        // Display employee information
        System.out.println("\nEmployee Information:\n" + employee.toString());

        scanner.close();
    }
}
