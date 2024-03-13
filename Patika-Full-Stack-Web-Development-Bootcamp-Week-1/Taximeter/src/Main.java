import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declaring variables.
        int distance;
        double fare, farePerKilometers = 2.20, startingPrice = 10; // Variable for fare calculation.

        // Creating a Scanner object for user input.
        Scanner input = new Scanner(System.in);

        // Getting the distance from the user.
        System.out.print("Enter the distance in kilometers: ");
        distance = input.nextInt();

        // Calculating the fare based on the distance and per-kilometer rate.
        fare = (distance * farePerKilometers);
        fare += startingPrice;

        // Checking if the fare is less than the minimum charge which is 20 TL.
        if (fare < 20){
            // If the fare is less than 20 TL, set the fare to the minimum charge.
            System.out.print("Your fare is: " + 20);
        }
        else {
            // If the fare is 20 TL or more, display the calculated rate.
            System.out.print("Your fare is: " + fare + " TL");

            input.close();
        }
    }
}
