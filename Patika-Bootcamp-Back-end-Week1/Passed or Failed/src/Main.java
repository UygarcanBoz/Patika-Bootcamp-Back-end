import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int courseCounter = 0;  // Counter to keep track of the number of courses entered

        // Getting the math grade from the user
        System.out.print("Enter your math grade: ");
        float math = input.nextInt();
        // Checking if the entered math grade is within the valid range (0 to 100)
        if (!(math >= 0 && math <= 100)) {
            math = 0;  // If not, set the grade to 0
        }
        courseCounter++;  // Incrementing the course counter

        // Getting the physics grade from the user
        System.out.print("Enter your physics grade: ");
        float physics = input.nextInt();
        // Checking if the entered physics grade is within the valid range (0 to 100)
        if (!(physics >= 0 && physics <= 100)) {
            physics = 0;  // If not, set the grade to 0
        }
        courseCounter++;  // Incrementing the course counter

        // Getting the Turkish grade from the user
        System.out.print("Enter your Turkish grade: ");
        float turkish = input.nextInt();
        // Checking if the entered Turkish grade is within the valid range (0 to 100)
        if (!(turkish >= 0 && turkish <= 100)) {
            turkish = 0;  // If not, set the grade to 0
        }
        courseCounter++;  // Incrementing the course counter

        // Getting the chemistry grade from the user
        System.out.print("Enter your chemistry grade: ");
        float chemistry = input.nextInt();
        // Checking if the entered chemistry grade is within the valid range (0 to 100)
        if (!(chemistry >= 0 && chemistry <= 100)) {
            chemistry = 0;  // If not, set the grade to 0
        }
        courseCounter++;  // Incrementing the course counter

        // Getting the music grade from the user
        System.out.print("Enter your music grade: ");
        float music = input.nextInt();
        // Checking if the entered music grade is within the valid range (0 to 100)
        if (!(music >= 0 && music <= 100)) {
            music = 0;  // If not, set the grade to 0
        }
        courseCounter++;  // Incrementing the course counter

        // Calculating the average of valid grades
        float average = (math + physics + turkish + chemistry + music) / courseCounter;
        System.out.println("Grade average: " + average);

        // Checking if the average is greater than or equal to the passing grade (55)
        if (average >= 55) {
            System.out.println("Congratulations, you have passed your courses.");
        } else {
            System.out.println("Sorry, you have failed your courses.");
        }
    }
}