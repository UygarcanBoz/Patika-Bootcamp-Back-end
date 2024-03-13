/** This project suggest an activity to the user based on temperature.
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the temperature
        System.out.print("Enter the temperature: ");
        int temperature = input.nextInt();

        // Use ternary operators to recommend activities based on temperature ranges
        String activity = (temperature < 5) ? "Skiing"
                : (temperature >= 5 && temperature <= 15) ? "Cinema"
                : (temperature > 15 && temperature <= 25) ? "Picnic"
                : "Swimming";

        // Display the recommended activity
        System.out.println("Recommended Activity: " + activity);

        // Closing the Scanner to prevent resource leaks
        input.close();
    }
}