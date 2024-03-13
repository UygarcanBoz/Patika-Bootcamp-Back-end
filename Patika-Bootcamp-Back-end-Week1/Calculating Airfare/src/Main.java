import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Getting information from the user.
        System.out.print("Enter the distance(km): ");
        int distance = input.nextInt();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.print("Select the trip type (1: One way, 2: Round trip): ");
        int tripType = input.nextInt();

        // Validating data input.
        if(distance > 0 && age > 0 && (tripType == 1 || tripType == 2)){
            double pricePerKilometer = 0.10;                    // Price per kilometer
            double baseFare = distance * pricePerKilometer;     // Calculating base fare

            // Applying discounts based on age.
            if (age < 12) {
                baseFare -= baseFare * 0.5;         // 50% discount for age under 12
            } else if (age >= 12 && age <= 24) {
                baseFare -= baseFare * 0.1;         // 10% discount for age between 12 and 24
            } else if (age >= 65) {
                baseFare -= baseFare * 0.3;         // 30% discount for age 65 and older
            }

            // Applying discount for round trip.
            if (tripType == 2) {
                baseFare *= 2;                  // Doubled the base fare for round trip
                baseFare -= baseFare * 0.2;     // 20% discount for raound trip
            }

            System.out.println("Total Price: " + baseFare + " TL");     // Displaying the result
        } else {
            System.out.println("Invalid data.");    // Displaying an error message for invalid input
        }

        input.close();  // Close the Scanner
    }
}
