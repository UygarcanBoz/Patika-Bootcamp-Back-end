import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaring variables to store grades for each subject
        double math, physics, chemistry, turkish, history, music;

        // Creating a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Getting input for each subject grade
        System.out.print("Enter your Math grade: ");
        math = input.nextDouble();

        System.out.print("Enter your Physics grade: ");
        physics = input.nextDouble();

        System.out.print("Enter your Chemistry grade: ");
        chemistry = input.nextDouble();

        System.out.print("Enter your Turkish grade: ");
        turkish = input.nextDouble();

        System.out.print("Enter your History grade: ");
        history = input.nextDouble();

        System.out.print("Enter your Music grade: ");
        music = input.nextDouble();

        // Calculating the total sum of grades
        double total = math + physics + chemistry + turkish + history + music;

        // Calculating the average grade
        double average = total / 6.0;

        // Displaying the average grade
        System.out.println("Your average grade is: " + average);

        // Checking if the student passed or failed
        boolean pass = average >= 60;

        // Determining the output message based on pass or fail
        String output = pass ? "Congratulations! You passed the class." : "Sorry, you failed the class.";

        // Displaying the final output message
        System.out.println(output);
    }
}